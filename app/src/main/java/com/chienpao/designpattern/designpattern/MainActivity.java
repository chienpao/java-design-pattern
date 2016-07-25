package com.chienpao.designpattern.designpattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.chienpao.designpattern.designpattern.decorator.IPacketCreator;
import com.chienpao.designpattern.designpattern.decorator.PacketBodyCreator;
import com.chienpao.designpattern.designpattern.decorator.PacketHTTPHeaderCreator;
import com.chienpao.designpattern.designpattern.decorator.PacketHtmlHeaderCreator;
import com.chienpao.designpattern.designpattern.flyWeight.IReportManager;
import com.chienpao.designpattern.designpattern.flyWeight.ReportManagerFactory;
import com.chienpao.designpattern.designpattern.observer.ConcreteObserver;
import com.chienpao.designpattern.designpattern.observer.ConcreteSubject;
import com.chienpao.designpattern.designpattern.proxy.DBProxyQuery;
import com.chienpao.designpattern.designpattern.singleton.factory.LazySingleton;
import com.chienpao.designpattern.designpattern.singleton.factory.Singleton;
import com.chienpao.designpattern.designpattern.singleton.factory.StaticSingleton;
import com.chienpao.designpattern.designpattern.valueObject.OrderManager;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private final int SINGLETON_TESTING_TIMES = 1000000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        launchSingleton();

        launchProxy();

        launchFlyWeight();

        launchDecorator();

        launchObserver();

        launchValueObject();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickHandler(View v) {

        switch (v.getId()) {
            case R.id.testing_singleton_button:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        long begin = System.currentTimeMillis();
                        for (int i = 0; i < SINGLETON_TESTING_TIMES; i++)
                            Singleton.getInstance();
                        Log.v(TAG, "Single spend:" + (System.currentTimeMillis() - begin));
                    }
                }).start();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        long begin = System.currentTimeMillis();
                        for (int i = 0; i < SINGLETON_TESTING_TIMES; i++)
                            LazySingleton.getInstance();
                        Log.v(TAG, "LazySingle spend:" + (System.currentTimeMillis() - begin));
                    }
                }).start();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        long begin = System.currentTimeMillis();
                        for (int i = 0; i < SINGLETON_TESTING_TIMES; i++)
                            StaticSingleton.getInstance();
                        Log.v(TAG, "StaticSingleton spend:" + (System.currentTimeMillis() - begin));
                    }
                }).start();
                break;
        }
    }

    private void launchSingleton() {
        // Sample code (1)
        Singleton.getInstance();

        // Sample code (2)
        LazySingleton.getInstance();

        // Sample code (3)
        StaticSingleton.getInstance();
    }

    private void launchProxy() {
        // Initial proxy
        DBProxyQuery dbProxyQuery = new DBProxyQuery();

        // Initial real object when request
        dbProxyQuery.request();
    }

    private void launchFlyWeight() {
        ReportManagerFactory rmf = new ReportManagerFactory();
        IReportManager rm = rmf.getFinancialReportManager("A");
        Log.v(TAG, rm.createReport());

        IReportManager rm2 = rmf.getFinancialReportManager("B");
        Log.v(TAG, rm2.createReport());

        IReportManager rm3 = rmf.getEmployeeReportManager("A");
        Log.v(TAG, rm3.createReport());

        IReportManager rm4 = rmf.getEmployeeReportManager("B");
        Log.v(TAG, rm4.createReport());
    }

    private void launchDecorator() {
        IPacketCreator pc = new PacketHTTPHeaderCreator(new PacketHtmlHeaderCreator(new PacketBodyCreator()));
        Log.v(TAG, pc.handleContent());
    }

    private void launchObserver() {
        ConcreteObserver observer1 = new ConcreteObserver();
        ConcreteObserver observer2 = new ConcreteObserver();
        ConcreteSubject subject = new ConcreteSubject();

        Log.v(TAG, "Observer Experiment 1 ===== Start =====");
        // Attach observer
        subject.attach(observer1);
        subject.inform();

        // Detach observer
        subject.detach(observer1);
        subject.inform();
        Log.v(TAG, "Observer Experiment 1 ===== End =====");

        Log.v(TAG, "Observer Experiment 2 ===== Start =====");
        // Attach observer
        subject.attach(observer1);
        subject.attach(observer2);
        subject.inform();

        // Detach observer
        subject.detach(observer1);
        subject.inform();
        subject.detach(observer2);
        subject.inform();
        Log.v(TAG, "Observer Experiment 2 ===== End =====");
    }

    private void launchValueObject() {
        OrderManager orderManager = new OrderManager();

        // Only one time
        orderManager.getOrder(1);

        // Need three times
        orderManager.getClientName(1);
        orderManager.getProdName(1);
        orderManager.getNumber(1);
    }
}
