package com.app.gandalf.piquatro.models;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SharedPreferencesCart {
    public static final String PREFS_NAME = "PRODUCT_APP";
    public static final String PRODUCTS = "Product";

    public SharedPreferencesCart() {
        super();
    }

    public boolean saveItens(Context context, List<Cart_List> list) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;
        try{
            settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
            editor = settings.edit();

            Gson gson = new Gson();

            // Valor já armazenado
            SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, context.MODE_PRIVATE);
            String retorno = prefs.getString(PRODUCTS, null);

            if(retorno == null){
                String json = gson.toJson(list);
                editor.putString(PRODUCTS, json);
                editor.commit();
            } else {
                JSONArray array = new JSONArray(retorno);
                Cart_List cartNew = null;

                int id, qtd;
                double preco, promocao;
                String nome, desc, image;

                // Adicionando produtos que já estavam no carrinho
                for(int i = 0; i < array.length(); i++){

                    id = array.getJSONObject(i).getInt("id");

                    if(id != list.get(0).getId()){
                        qtd = array.getJSONObject(i).getInt("qtd");

                        preco = array.getJSONObject(i).getDouble("preco");
                        promocao = array.getJSONObject(i).getDouble("promocao");

                        nome = array.getJSONObject(i).getString("nome");
                        desc = array.getJSONObject(i).getString("desc");
                        image = array.getJSONObject(i).getString("image");

                        cartNew = new Cart_List(id, nome, desc, image, preco, promocao, qtd);
                        list.add(cartNew);
                    }
                }

                String json = gson.toJson(list);
                editor.putString(PRODUCTS, json);
                editor.commit();
            }


        } catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public void addItem(Context context, Cart_List cart) {
        List<Cart_List> list = getItens(context);
        if (list == null)
            list = new ArrayList<Cart_List>();
            list.add(cart);
    }

    public ArrayList<Cart_List> getItens(Context context) {
        SharedPreferences settings;
        List<Cart_List> list;

        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        if (settings.contains(PRODUCTS)) {
            String json = settings.getString(PRODUCTS, null);
            Gson gson = new Gson();
            Cart_List[] Itens = gson.fromJson(json, Cart_List[].class);

            list = Arrays.asList(Itens);
            list = new ArrayList<Cart_List>(list);
        } else {
            return null;
        }

        return (ArrayList<Cart_List>) list;
    }

    public void removeIten(Context context, Cart_List cart) {
        ArrayList<Cart_List> list = getItens(context);
        if (list != null) {
            list.remove(cart);
            saveItens(context, list );
        }
    }

    public void removeSharedItens(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(PRODUCTS, null);
        editor.apply();
    }


}
