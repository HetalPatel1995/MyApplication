package com.example.admin.myapplication.Activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.admin.myapplication.Adepter.PropertyAdapter;
import com.example.admin.myapplication.Helper.Property;
import com.example.admin.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


// * A simple {@link Fragment} subclass.
// * Activities that contain this fragment must implement the
 /* {@link HomeViewPage.OnFragmentInteractionListener} interface */
// * to handle interaction events.
// * Use the {@link HomeViewPage#newInstance} factory method to
// * create an instance of this fragment.

public class HomeViewPage extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @BindView(R.id.SearchRecycleView)
    RecyclerView recyclerView;

//    @BindView(R.id.property_card)
//    CardView property_card;

    //a list to store all the products
    List<Property> propertyList;

    PropertyAdapter propertyAdapter;
    String property;


//    private OnFragmentInteractionListener mListener;

    public HomeViewPage() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeViewPage.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeViewPage newInstance(String param1, String param2) {
        HomeViewPage fragment = new HomeViewPage();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home_view_page, container, false);

        View view = inflater.inflate(R.layout.fragment_home_view_page, container, false);

        ButterKnife.bind(this,view);
//        Paper.init(getActivity());

        //getting the recyclerview from xml
       recyclerView.setHasFixedSize(true);
recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

//        initializing the productlist
        propertyList = new ArrayList<>();


//        adding some items to our list
        propertyList.add(
                new Property(
                        1,
                        "₹ 96.3 lac",
                        "3 BHK flat 1615 sqft",
                        "Satelite Ahmedabad",
                        "Sheetal appt",
                        R.drawable.home1));

        propertyList.add(
                new Property(
                        1,
                        "₹ 96.3 lac",
                        "Plot",
                        "paldi Ahmedabad",
                        "Blis houses",
                        R.drawable.home2));

        propertyList.add(
                new Property(
                        1,
                        "₹ 62 lac",
                        "3 BHK Flat",
                        "South Bhopal Ahmedabad",
                        "Aruna Appartment",
                        R.drawable.home3));


       propertyAdapter=new PropertyAdapter(getActivity(),propertyList);

        //setting adapter to recyclerview
       recyclerView.setAdapter(propertyAdapter);

//        initCode();
        return view;
    }


//    private void initCode(){
//
//        final RestCall call = RestClient.createService(RestCall.class);
//
//        call.getProperty("mhkey","getProperty")
//                .subscribeOn(Schedulers.io())
//                .observeOn(Schedulers.newThread())
//                .subscribe(new Subscriber<PropertyResponce>() {
//
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(final Throwable e) {
//
//                        getActivity().runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                recyclerView.setVisibility(View.GONE);
//
//                                Toast.makeText(getActivity(), ""+e.getMessage(), Toast.LENGTH_SHORT).show();
//
//                            }
//                        });
//
//                    }
//
//                    @Override
//                    public void onNext(final PropertyResponce propertyResponce) {
//
//                        getActivity().runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                if (propertyResponce.getStatus().equalsIgnoreCase("200")){
//                                    recyclerView.setVisibility(View.VISIBLE);
//                                    propertyAdapter = new PropertyAdapter(getActivity(),propertyResponce);
//                                    //recyclerView.setAdapter(propertyAdapter);
//
//                                    recyclerView.setHasFixedSize(true);
//                                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//                                    recyclerView.setAdapter(propertyAdapter);
//
//                                    propertyAdapter.setUpInterface(new PropertyAdapter.PropertyInterface() {
//                                        @Override
//                                        public void click(String data, int pos) {
//
//
//                                            property = data;
//
//                                            Paper.book().write("property_id",property);
//                                            // property_card.setOnClickListener(new View.OnClickListener() {
//                                            //  @Override
//                                            // public void onClick(View v) {
//                                            Intent intent = new Intent(getActivity(), ViewProperty.class);
//                                            intent.putExtra("property_id",property);
//                                            startActivity(intent);
//                                            //    }
//                                            // });
//
//
//
//
////                                            btn_continue.setEnabled(true);
////                                            btn_continue.setBackgroundColor(ContextCompat.getColor(SelectSocietyActivity.this, R.color.green_300));
//                                            propertyAdapter.notifyDataSetChanged();
//
//                                        }
//                                    });
//
//                                }else {
//
//                                    //Tools.toast(Notification.this,notificationResponce.getMessage(),0);
//                                    recyclerView.setVisibility(View.GONE);
//
//
//                                }
//                            }
//                        });
//
//                    }
//                });
//
//    }


    // TODO: Rename method, update argument and hook method into UI event
    /*public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
*/


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
   /* public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/
}
