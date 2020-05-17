package learn.android.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private int quantity = 0;
    private Spinner spinner;
    private ArrayList spinnerArrayList;
    private ArrayAdapter spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addQty(0);

        spinner = findViewById(R.id.spinner);
        spinnerArrayList = new ArrayList<String>();
        spinnerArrayList.add("guitar");
        spinnerArrayList.add("drums");
        spinnerArrayList.add("keyboard");

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }

    private void addQty(int qty) {
        TextView qtyTextView = findViewById(R.id.quantityTextView);
        quantity += qty;

        if (quantity < 0) quantity = 0;
        qtyTextView.setText("" + quantity);
    }

    public void minusButtonClick(View view) {
        addQty(-1);
    }

    public void plusButtonClick(View view) {
        addQty(1);
    }
}
