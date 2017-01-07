package com.example.teo.a7checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox pizza, coffe, burger;
    Button buttonOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButtonClick();
    }

    public void addListenerOnButtonClick(){
        //Getting instance of CheckBoxes and Button from the activity main.xml file
        pizza = (CheckBox) findViewById(R.id.checkbox1);//Bánh pizza
        coffe = (CheckBox) findViewById(R.id.checkbox2);//Cà phê
        burger = (CheckBox) findViewById(R.id.checkbox3);//Bánh hamburger
        buttonOrder = (Button) findViewById(R.id.button1);//Button gọi món

        //Applying the Listener on the Button click
        //Bắt sự kiện click button Order
        buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Tổng tiền
                int totalamount=0;
                StringBuilder result = new StringBuilder();//Khai báo biến lưu trữ string
                result.append("Selected Items: ");
                //Kiểm tra nếu checkbox pizza được chọn thì trả về kết quả
                if (pizza.isChecked()){
                    result.append("\nPizza 100Rs");
                    totalamount += 100;
                }
                if (coffe.isChecked()){
                    result.append("\nCoffe 50Rs");
                    totalamount += 50;
                }
                if (burger.isChecked()){
                    result.append("\nBurger 120Rs");
                    totalamount += 120;
                }
                //Thêm một dòng để in kết quả của tổng tiền
                result.append("\nTotal : "+totalamount+"Rs");
                //Displaying the message on the toast
                //Hiển thị message nội dung của order
                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
