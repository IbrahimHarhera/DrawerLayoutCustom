package com.example.ibrahim.drawermenu;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ExpandedMenuView;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<MenuItem> list;
    private MenuAdapter adapter;
    private ListView listView;
    private DrawerLayout drawerLayout;
    private FrameLayout mainContent;
    LinearLayout linearLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private boolean isMenuOpened=false;
    TextView tvContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initEvents();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        actionBarDrawerToggle.syncState();
    }

    public void openMenu(View view){
        if (isMenuOpened){
            drawerLayout.closeDrawer(Gravity.LEFT);
            isMenuOpened=false;
        }else{
            drawerLayout.openDrawer(Gravity.LEFT);
            isMenuOpened=true;
        }
    }

    private void initEvents() {

        //on choose item on menu
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tvContent.setText(list.get(position).getTitle().toString());
                listView.setItemChecked(position,true);

                drawerLayout.closeDrawer(linearLayout);
            }
        });


        //on click menu action button
        actionBarDrawerToggle=new ActionBarDrawerToggle(MainActivity.this,drawerLayout,R.drawable.ic_menu,
                R.string.menu_open,R.string.menu_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                isMenuOpened=true;
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                isMenuOpened=false;
                invalidateOptionsMenu();
            }
        };
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
    }

    private void initViews() {
        isMenuOpened=false;
        listView =(ListView)findViewById(R.id.listView);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        mainContent=(FrameLayout) findViewById(R.id.frame_layout);
        tvContent=(TextView)findViewById(R.id.tv_main);
        linearLayout=(LinearLayout)findViewById(R.id.menu_container);
        list =new ArrayList<>();
        list.add(new MenuItem(R.drawable.ic_menu,"Home"));
        list.add(new MenuItem(R.drawable.ic_menu,"Setting"));
        list.add(new MenuItem(R.drawable.ic_menu,"Logout"));
        adapter=new MenuAdapter(this, list);
        listView.setAdapter(adapter);

        listView.setItemChecked(0,true);
        drawerLayout.closeDrawer(linearLayout);
        replaceFragment(0);


    }

    private void replaceFragment(int i) {
        switch (i){
            case 0:
                tvContent.setText("0");
                break;
            case 1:
                tvContent.setText("1");
                break;
            case 2:
                tvContent.setText("2");
                break;
        }
    }
}
