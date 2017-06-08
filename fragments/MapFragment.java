package fr.unice.polytech.enseigne_client.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import fr.unice.polytech.enseigne_client.R;
import fr.unice.polytech.enseigne_client.data.Database;
import fr.unice.polytech.enseigne_client.data.Shop;

/**
 * Created by user on 17/05/2017.
 */

public class MapFragment extends Fragment implements OnMapReadyCallback {

//    private GoogleMap mGoogleMap;
//
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState){
//        View rootView = inflater.inflate(R.layout.fragment_map, container, false);
//        return rootView;
//    }

    private MapView mMapView;
    private GoogleMap mGoogleMap;
    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mView = inflater.inflate(R.layout.fragment_map, container, false);
        return mView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMapView = (MapView) mView.findViewById(R.id.mapView);
        if (mMapView != null) {
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());
        mGoogleMap = googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.setTrafficEnabled(true);
        for (Shop shop : Database.shopDatabase.values()) {
            if (shop.getVille().equals("Hamhung"))
                googleMap.addMarker(new MarkerOptions().position(new LatLng(shop.getLatitude(), shop.getLongitude())).title(shop.getVille()).snippet("Pourquoi pas?"));

            else
                googleMap.addMarker(new MarkerOptions().position(new LatLng(shop.getLatitude(), shop.getLongitude())).title(shop.getVille()).snippet("To Be or To Have"));
        }

        CameraPosition mCapSophia = CameraPosition.builder().target(new LatLng(43.614954, 7.072701)).zoom(5).bearing(0).tilt(45).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(mCapSophia));
    }
}
