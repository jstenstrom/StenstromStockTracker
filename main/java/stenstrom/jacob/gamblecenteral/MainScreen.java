package stenstrom.jacob.gamblecenteral;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }

    public void reachBlack(View view){
        Intent intent = new Intent(this,BlackJack.class);
        startActivity(intent);
    }
    public void reachStock(View view){
        Intent intent = new Intent(this,Stocks.class);
        startActivity(intent);
    }
}
