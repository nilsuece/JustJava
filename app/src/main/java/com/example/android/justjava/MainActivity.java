package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 0;

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice();
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whippedcream_checkbox);
        boolean hasWhippedCream = (boolean) whippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = (boolean) chocolateCheckBox.isChecked();
        displayMessage(createOrderSummary(price, hasWhippedCream, hasChocolate));

    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);

    }

    public void decrement(View view) {

        quantity = quantity - 1;
        displayQuantity(quantity);
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int piece) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + piece);
    }


    /**
     * Calculates the price of the order.
     *
     * @return total price
     * @Param quantity is the number of cups of coffee ordered
     */

    private int calculatePrice() {
        return quantity * 5;
    }

    /**
     * Create summary of the order.
     *
     * @param price of the order
     * @param addWhippedCream is whether or not  user wants whipped cream topping
     * @return order summary
     */

    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate) {
        String priceMessage = "Name: Nilsu";
        priceMessage += "\nAdd whipped cream? " + addWhippedCream;
        priceMessage += "\nAdd chocolate? " + addChocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }


}