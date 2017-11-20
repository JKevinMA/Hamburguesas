package com.example.kevin.hamburguesas.Fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.kevin.hamburguesas.Adp_elementos;
import com.example.kevin.hamburguesas.Beans.Elemento;
import com.example.kevin.hamburguesas.JSONParser;
import com.example.kevin.hamburguesas.R;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class CreacionFragment extends Fragment {
    JSONParser obj;
    String url ="http://10.0.2.2:80/Servidor/Servicio2.php";
    ListView lw,lwelem;
    ProgressDialog dg;

    private OnFragmentInteractionListener mListener;
    FloatingActionButton fab2;
    public CreacionFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreateView(inflater,container,savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_creacion, container, false);
        obj=new JSONParser();
        lwelem=(ListView)v.findViewById(R.id.lstelementos);
        new asincrono().execute();
        return v;
    }

    public class asincrono extends AsyncTask<String,Void,String> {
        List<Elemento> lista=new ArrayList();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dg=new ProgressDialog(getContext());
            dg.setMessage("Procesando...");
            dg.setCancelable(false);
            dg.show();
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //el proceso finaliza
            dg.dismiss();
            Adp_elementos dp=new Adp_elementos(getContext(),0,lista);
            lwelem.setAdapter(dp);
        }
        @Override
        protected String doInBackground(String... params) {

            List prm=new ArrayList();
            prm.add(new BasicNameValuePair("opc","lista"));
            try {
                JSONObject jsn = obj.makeHttpRequest(url,"POST",prm);
                Log.d("info",jsn.toString());
                JSONArray vec=jsn.getJSONArray("data");
                //leer data y llenar la lista
                for (int f=0;f<vec.length();f++){
                    JSONObject row=vec.getJSONObject(f);
                    Elemento a =new Elemento();
                    a.setId(row.getInt("id"));
                    a.setNombre(row.getString("nombre"));
                    a.setDescripcion(row.getString("descripcion"));
                    a.setPrecio(row.getDouble("precio"));
                    a.setTipo(row.getString("tipo"));
                    lista.add(a);
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
            return null;
        }

    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
