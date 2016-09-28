package stenstrom.jacob.gamblecenteral;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.math.BigDecimal;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.quotes.stock.StockQuote;

public class Stocks extends AppCompatActivity {
    protected static TextView goo,mc,in,ap,da,ocu,di,so,lin,te;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stocks);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        goo = new TextView(this);
        mc = new TextView(this);
        in = new TextView(this);
        ap = new TextView(this);
        da = new TextView(this);
        ocu = new TextView(this);
        di = new TextView(this);
        so = new TextView(this);
        lin = new TextView(this);
        te = new TextView(this);

        //YahooFinance yh = new YahooFinance();



        goo = (TextView) findViewById(R.id.text_googStock);
        mc = (TextView) findViewById(R.id.text_microStock);
        in = (TextView) findViewById(R.id.text_intuitStock);
        ap = (TextView) findViewById(R.id.text_appStock);
        //da=(TextView)findViewById(R.id.text_cards);
        ocu = (TextView) findViewById(R.id.text_ocStock);
        di = (TextView) findViewById(R.id.text_disStock);
        so = (TextView) findViewById(R.id.text_sonStock);
        lin = (TextView) findViewById(R.id.text_linkStock);
        te = (TextView) findViewById(R.id.text_tesStock);

        new RetrieveStockInfo().execute();
    }
        /*goo.setText(""+g);
        mc.setText(""+m);
        in.setText(""+i);
        ap.setText(""+a);
        ocu.setText(""+o);
        di.setText(""+d);
        so.setText(""+s);
        lin.setText(""+l);
    }*/

    public void refreshClick(View view){
        new RetrieveStockInfo().execute();
        /*try {
            goog = YahooFinance.get("GOOG");
            mic = YahooFinance.get("MSFT");
            intu = YahooFinance.get("ITU.F");
            app = YahooFinance.get("AAPL");
            oc = YahooFinance.get("FB");
            dis = YahooFinance.get("DIS");
            son = YahooFinance.get("SNE");
            link = YahooFinance.get("LNKD");
            tes = YahooFinance.get("TSLA");

            g = goog.getQuote().getPrice();
            m = mic.getQuote().getPrice();
            i = intu.getQuote().getPrice();
            a = app.getQuote().getPrice();
            o = oc.getQuote().getPrice();
            d = dis.getQuote().getPrice();
            s = son.getQuote().getPrice();
            l = link.getQuote().getPrice();
            t = tes.getQuote().getPrice();


        } catch (IOException e) {
            e.printStackTrace();
        }
        goo.setText(""+g);
        mc.setText(""+m);
        in.setText(""+i);
        ap.setText(""+a);
        ocu.setText(""+o);
        di.setText(""+d);
        so.setText(""+s);
        lin.setText(""+l);*/
    }

}
class RetrieveStockInfo extends AsyncTask<String, Void, BigDecimal> {
    Stock goog,mic,intu,app,dat,oc,dis,son,link,tes;
    BigDecimal g,m,i,a,o,d,s,l,t;

    private Exception exception;

    protected BigDecimal doInBackground(String... urls) {
        try {
            goog = YahooFinance.get("GOOG");
            mic = YahooFinance.get("MSFT");
            intu = YahooFinance.get("ITU.F");
            app = YahooFinance.get("AAPL");
            oc = YahooFinance.get("FB");
            dis = YahooFinance.get("DIS");
            son = YahooFinance.get("SNE");
            link = YahooFinance.get("LNKD");
            tes = YahooFinance.get("TSLA");
            //try {
            g = goog.getQuote().getPrice();
            m = mic.getQuote().getPrice();
            i = intu.getQuote().getPrice();
            a = app.getQuote().getPrice();
            o = oc.getQuote().getPrice();
            d = dis.getQuote().getPrice();
            s = son.getQuote().getPrice();
            l = link.getQuote().getPrice();
            t = tes.getQuote().getPrice();


        } catch (IOException e) {
            e.printStackTrace();
        }
        return g;
    }

    protected void onPostExecute(BigDecimal stockValue) {
        Stocks.goo.setText(" " + g);
        Stocks.mc.setText(" " + m);
        Stocks.in.setText(" " + i);
        Stocks.ap.setText(" "+a);
        Stocks.ocu.setText(" "+o);
        Stocks.di.setText(" "+d);
        Stocks.so.setText(" "+s);
        Stocks.lin.setText(" "+l);
        Stocks.te.setText(" "+t);
    }
}
