package learn.android.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private int quantity = 0;
    private Spinner spinner;
    private ArrayList spinnerArrayList;
    private ArrayAdapter spinnerAdapter;
    private HashMap goodsMap;
    private String goodName;
    private double price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addQty(0);

        initMap();
        initSpinner();
    }

    private void initMap() {
        goodsMap = new HashMap();
        goodsMap.put("guitar", 500.0);
        goodsMap.put("drums", 1500.0);
        goodsMap.put("keyboard", 500.0);
    }

    private void initSpinner() {
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArrayList = new ArrayList<String>();
        spinnerArrayList.addAll(goodsMap.keySet());

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }

    private void addQty(int qty) {
        TextView qtyTextView = findViewById(R.id.quantityTextView);
        quantity += qty;

        if (quantity < 0) quantity = 0;
        qtyTextView.setText("" + quantity);

        TextView priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText("" + quantity * price);
    }

    public void minusButtonClick(View view) {
        addQty(-1);
    }

    public void plusButtonClick(View view) {
        addQty(1);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        goodName = spinner.getSelectedItem().toString();
        price = (double) goodsMap.get(goodName);

        ImageView imgGoodPic = findViewById(R.id.imgGoodPic);
        imgGoodPic.setImageResource(getResources().getIdentifier("mouse_" + goodName, "drawable", getPackageName()));

        addQty(0);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        price = 0;
        addQty(0);
    }
}
