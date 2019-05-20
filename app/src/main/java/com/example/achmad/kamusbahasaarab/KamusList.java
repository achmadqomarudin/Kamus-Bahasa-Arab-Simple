package com.example.achmad.kamusbahasaarab;

import android.app.Dialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.Locale;

public class KamusList extends ListActivity implements AppCompatCallback{

    protected EditText searchText;
    protected SQLiteDatabase db;
    protected Cursor cursor;
    protected ListAdapter adapter;
    protected ImageButton btnDelete;
    private Dialog MyDialog;
    private Button btn_tutup, btn_beri_rating;
    private AppCompatDelegate delegate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kamuslist_main);

        /**
         * Custom title bar without AppCompactActivity
         **/

        //let's create the delegate, passing the activity at both arguments (Activity, AppCompatCallback)
        delegate = AppCompatDelegate.create(this, this);

        //we need to call the onCreate() of the AppCompatDelegate
        delegate.onCreate(savedInstanceState);

        //we use the delegate to inflate the layout
        delegate.setContentView(R.layout.kamuslist_main);

        //Finally, let's add the Toolbar
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        delegate.setSupportActionBar(toolbar);

        /**
         * Menu Navigation Drawer
         **/

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        initComponentsNavHeader();

        btnDelete = findViewById(R.id.delete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchText.setText(null);
            }
        });

        searchText = (EditText) findViewById(R.id.searchText);
        db = (new DatabaseHelper(this)).getWritableDatabase();

        searchText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // Filtering Text
                //njajal
                search(getListView()); //ini yg asli
                // Filtering Color Text
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });
    }

    private void initComponentsNavHeader(){
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_kamus:
                        Pesan("Menu Kamus");
                        break;
                    case R.id.nav_bookmark:
                        Pesan("Menu Bookmark");
                        break;
                    case R.id.nav_history:
                        Pesan("Menu History");
                        break;
                    case R.id.nav_app_lain:
                        Pesan("Menu App Lainnya");
                        break;
                    case R.id.nav_info_app:
//                        Pesan("Menu App Info");
                        AboutDialog();
                        break;
                }

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }

            private void Pesan(String pesan) {
                Toast.makeText(KamusList.this, pesan, Toast.LENGTH_SHORT).show();
            }
        });

//        View headerView = navigationView.getHeaderView(0);
//        imgview_barcode = (ImageView) headerView.findViewById(R.id.imgview_barcode);
//        imgview_barcode.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showToast("barcode");
//            }
//        });
//
//        imgview_fotoprofil = (CircleImageView) headerView.findViewById(R.id.imgview_fotoprofil);
//        imgview_fotoprofil.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showToast("Foto Profil");
//            }
//        });

    }

    @SuppressWarnings("deprecation")
    public void search(View view) {
        // || is the concatenation operation in SQLite
        cursor = db.rawQuery("SELECT * FROM employee WHERE arb2 || ' ' || ind LIKE ?",
                new String[]{"%" + searchText.getText().toString() + "%"});
        adapter = new SimpleCursorAdapter(
                this,
                R.layout.kamus_list_item,
                cursor,
                new String[]{"arb2", "ind"},
                new int[]{R.id.arb2, R.id.ind});
        ListView lv = findViewById(android.R.id.list);
        lv.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void AboutDialog() {
        MyDialog = new Dialog(KamusList.this);
        MyDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyDialog.setContentView(R.layout.about_dialog);
        MyDialog.setTitle("My Custom Dialog");

        btn_tutup = MyDialog.findViewById(R.id.btn_tutup);
        btn_tutup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDialog.dismiss();
            }
        });

        btn_beri_rating = MyDialog.findViewById(R.id.btn_beri_rating);
        btn_beri_rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toas("Masih dalam tahap pengembangan");
            }
        });

        MyDialog.show();
    }

    public void Toas(String pesan){
        Toast.makeText(this, pesan, Toast.LENGTH_LONG).show();
    }


    /**
     * Custom title bar without AppCompatActivity
     **/
    @Override
    public void onSupportActionModeStarted(ActionMode mode) {

    }

    @Override
    public void onSupportActionModeFinished(ActionMode mode) {

    }

    @Nullable
    @Override
    public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback callback) {
        return null;
    }
}
