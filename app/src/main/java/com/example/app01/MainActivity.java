package com.example.app01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;






public class MainActivity extends AppCompatActivity {
    private Button button;
    private ImageView chicken1, tea1;
    private TextView product_name1, product_name2;
    private int quantity1,quantity2 = 0;
    private int selectedProductId = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        tea1 = findViewById(R.id.tea1);
        chicken1 = findViewById(R.id.chicken1);
        product_name1 = findViewById(R.id.product_name1);
        product_name2 = findViewById(R.id.product_name2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] products = {"tea1", "chicken1"};


            }
        });
        tea1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedProductId = 1; // ID товара "Чай"
                quantity1++; // Увеличиваем количество
                Toast.makeText(MainActivity.this, "Выбран Товар Чай. Количество: " + quantity1, Toast.LENGTH_SHORT).show();
            }
        });
        chicken1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedProductId = 2; // ID товара "Курица"
                quantity2++; // Увеличиваем количество
                Toast.makeText(MainActivity.this, "Выбран Товар Курица. Количество: " + quantity2, Toast.LENGTH_SHORT).show();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedProductId != -1 && quantity1 > 0) {
                    placeOrder(selectedProductId, quantity1, quantity2); // Отправка заказа на сервер
                    resetOrder(); // Сбросить количество после заказа
                    Toast.makeText(MainActivity.this, "Заказ отправлен", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Пожалуйста, выберите товар", Toast.LENGTH_SHORT).show();
                }
            }


        });
    }

    private void placeOrder(int productId, int quantity,int quanity2) {
        String url = "http://localhost/eeee.php"; // Замените на ваш URL

    }

    private void resetOrder() {
        selectedProductId = -1; // Сбросить выбранный продукт
        quantity1 = 0; // Сбросить количество
        quantity2 = 0;

    }
}