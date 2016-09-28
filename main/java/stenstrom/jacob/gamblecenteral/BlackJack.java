package stenstrom.jacob.gamblecenteral;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class BlackJack extends AppCompatActivity {

    Turn test;
    int bet = 0;
    int cash;
    Random draw1;
    Random draw2;
    Random hit;
    int firstDraw, secondDraw, extraDraw,handValueOpp,handValue;
    TextView cardsText, oppCardsText, potText, chipsText, winLoseText;
    String[] cards={"1","2","3","4","5","6","7","8","9","10","J","Q","K","A"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black_jack);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        cardsText = new TextView(this);
        cardsText=(TextView)findViewById(R.id.text_cards);
        oppCardsText = new TextView(this);
        potText = new TextView(this);
        chipsText = new TextView(this);
        winLoseText = new TextView(this);

        oppCardsText=(TextView)findViewById(R.id.text_dealCard);
        potText=(TextView)findViewById(R.id.text_pot);
        chipsText=(TextView)findViewById(R.id.text_chips);
        winLoseText=(TextView)findViewById(R.id.text_winlose);

        draw1 = new Random();
        draw2 = new Random();
        hit = new Random();

        cash = 100;
        bet =0;
        chipsText.setText(""+cash);
        potText.setText(""+bet);
        //this.test = Turn.MYTURN;
    }
    public void reachRules(View view){
        Intent intent = new Intent(this,RulesActivity.class);
        startActivity(intent);
    }
    public void reachStats(View view){
        Intent intent = new Intent(this,Stats.class);
        startActivity(intent);
    }
    public enum Turn{
        MYTURN, DEALERTURN
    }
    public void stand(View view){
        cash = cash-bet;
        chipsText.setText(""+cash);
        potText.setText(""+bet);
        firstDraw = draw1.nextInt(11)+1;
        SystemClock.sleep(10);
        secondDraw = draw2.nextInt(11)+1;
        if (secondDraw==11){
            secondDraw=1;
        }
        handValueOpp = firstDraw + secondDraw;
        oppCardsText.setText("" + handValueOpp);
        SystemClock.sleep(1000);
        if (handValueOpp==21){
            winLoseText.setText("Dealer has blackjack! You Lose!");
            SystemClock.sleep(2000);
        }else {
            while (handValueOpp < 17) {
                extraDraw = hit.nextInt(11) + 1;
                if(extraDraw==11){
                    winLoseText.setText("Dealer drew an A");
                }else if(extraDraw==10){
                    Random rand = new Random();
                    int helper = rand.nextInt(4);
                    winLoseText.setText("Dealer drew a " +cards[9+helper]);
                }else {
                    winLoseText.setText("Dealer drew a " +cards[extraDraw-1]);
                }
                if (extraDraw == 11) {
                    extraDraw = 1;
                }
                handValueOpp += extraDraw;
                oppCardsText.setText(""+handValueOpp);
            }
            if(handValueOpp>21){
                winLoseText.setText("You Win! We have given you a New Hand!");
                SystemClock.sleep(1500);
                cash = cash + (2 * bet);
            }else {
                if (handValue > handValueOpp) {
                    winLoseText.setText("You Won! We have given you a New Hand!");
                    SystemClock.sleep(1500);
                    cash = cash + (2 * bet);
                } else if (handValue == handValueOpp) {
                    winLoseText.setText("You Tied! We have given you a New Hand!");
                    SystemClock.sleep(1500);
                    cash = cash + bet;
                } else {
                    winLoseText.setText("You Lost! We have given you a New hand!");
                    SystemClock.sleep(1500);
                }
            }
            SystemClock.sleep(5000);
            firstDraw = draw1.nextInt(11) + 1;
            SystemClock.sleep(1000);
            secondDraw = draw2.nextInt(11) + 1;
            if (secondDraw == 11) {
                secondDraw = 1;
            }
            handValue = firstDraw + secondDraw;
            cardsText.setText(""+handValue);
            if (handValue==21){
                winLoseText.setText("You had blackjack! You Won!");
                SystemClock.sleep(1500);
                cash = cash + (2 * bet);
                chipsText.setText("" + cash);
                firstDraw = draw1.nextInt(11) + 1;
                SystemClock.sleep(1500);
                secondDraw = draw2.nextInt(11) + 1;
                if (secondDraw == 11) {
                    secondDraw = 1;
                }
                handValue = firstDraw + secondDraw;
                cardsText.setText(""+handValue);
            }
        }
        bet=0;
        chipsText.setText(""+cash);
        potText.setText(""+bet);
    }
    public void hit(View view){
        extraDraw = hit.nextInt(11)+1;
        if (extraDraw==11){
            extraDraw=1;
        }

        if(extraDraw==11){
            winLoseText.setText("You drew an A");
        }else if(extraDraw==10){
            Random rand = new Random();
            int helper = rand.nextInt(4);
            winLoseText.setText("You drew a " +cards[9+helper]);
        }else {
            winLoseText.setText("You drew a " +cards[extraDraw-1]);
        }
        handValue+=extraDraw;
        cardsText.setText(""+handValue);
        SystemClock.sleep(2000);
        if(handValue>21){
            winLoseText.setText("You drew over 21! You Lose!");
            handValue = 0;
            cardsText.setText("");
            cash=cash-bet;
            chipsText.setText(""+cash);
            bet=0;
            potText.setText(""+bet);
        }
    }
    public void raise_One(View view){
        bet+=1;
        potText.setText(""+bet);
    }
    public void raise_Ten(View view){
        bet+=10;
        potText.setText(""+bet);
    }

}
