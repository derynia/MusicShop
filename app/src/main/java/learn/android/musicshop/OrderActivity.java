package learn.android.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        setTitle("Your order");

        TextView orderTextView  = findViewById(R.id.orderTextView);
        Bundle arguments = getIntent().getExtras();
        final Order order;
        if (arguments != null) {
            order = (Order) arguments.getSerializable(Order.class.getSimpleName());
            orderTextView.setText(order.toStringForTextView());
        }
    }
}
