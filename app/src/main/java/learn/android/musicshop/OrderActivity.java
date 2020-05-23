package learn.android.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {
    private Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        setTitle("Your order");

        TextView orderTextView  = findViewById(R.id.orderTextView);
        Bundle arguments = getIntent().getExtras();
        if (arguments != null) {
            order = (Order) arguments.getSerializable(Order.class.getSimpleName());
            orderTextView.setText(order.toStringForTextView());
        }
    }

    public void submitOrder(View view) {
        if (order == null) {
            Toast.makeText(getApplicationContext(), "Order does not exist", Toast.LENGTH_SHORT).show();
            return;
        }

        String[] addresses = {"derynia@gmail.com"};
        String subject = "Order from Music Shop";

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        //intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, order.toStringForTextView());

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
