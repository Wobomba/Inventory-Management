package com.example.pos.ui.home;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.pos.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    EditText pdname, pri, qty, sub, pay, balance;
    Button add,cls;
    private ArrayList<String> info=new ArrayList<String>();
    private ArrayList<String> info1=new ArrayList<String>();
    private ArrayList<String> info2=new ArrayList<String>();
    private ArrayList<String> info3=new ArrayList<String>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        pdname=(EditText)view.findViewById(R.id.edit_home);
        pri=(EditText)view.findViewById(R.id.edit_price);
        qty=(EditText)view.findViewById(R.id.edit_qty);
        sub=(EditText)view.findViewById(R.id.edit_sub_total);
        pay=(EditText)view.findViewById(R.id.edit_pay);
        balance=(EditText)view.findViewById(R.id.edit_bal);
        add=(Button)view.findViewById(R.id.add);
        //cls=(Button)view.findViewById(R.id.clear);
        //the moment the sub total value changes, on input of the balance figure, a calculation should be performed
        /*cls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pdname.setText("");
                pri.setText("");
                qty.setText("");
                pay.setText("");
            }
        });*/
        pay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int subtotal=Integer.parseInt(sub.getText().toString());
                int payee=Integer.parseInt(pay.getText().toString());
                if(subtotal>payee){
                    pay.setError("Amount entered is less");
                }
                else if(subtotal<=payee){
                    int balaance=payee-subtotal;
                    balance.setText(String.valueOf(balaance));
                }

            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tot;
                String productnames=pdname.getText().toString().trim();
                String ps=pri.getText().toString().trim();
                String qts=qty.getText().toString().trim();
                String pays=pay.getText().toString().trim();
                //form validation
                if(productnames.isEmpty()||ps.isEmpty()||qts.isEmpty()){
                    pdname.setError("Required field");
                    pri.setError("Required field");
                    qty.setError("Required field");
                }
                else if(productnames.isEmpty()&&ps.isEmpty()){
                    pdname.setError("Required field");
                    pri.setError("Required field");
                }
                else if(ps.isEmpty()&&qts.isEmpty()){
                    pri.setError("Required field");
                    qty.setError("Required field");
                }
                else if(productnames.isEmpty()&&qts.isEmpty()){
                    pdname.setError("Required field");
                    qty.setError("Required field");
                }
                /*
                else if(productnames.isEmpty()&&pays.isEmpty()){
                    pdname.setError("Required field");
                    pay.setError("Required field");
                }
                else if(ps.isEmpty()&&qts.isEmpty()){
                    pri.setError("Required field");
                    pay.setError("Required field");
                }
                else if(qts.isEmpty()&&pays.isEmpty()){
                    qty.setError("Required field");
                    pay.setError("Required field");
                }
                else if(productnames.isEmpty()&&ps.isEmpty()&&qts.isEmpty()){
                    pdname.setError("Required field");
                    pri.setError("Required field");
                    qty.setError("Required field");
                    pay.setError("Required field");
                }*/
                else{
                    String productname=pdname.getText().toString();
                    int prices=Integer.parseInt(pri.getText().toString());
                    int quantity=Integer.parseInt(qty.getText().toString());

                    tot=prices*quantity;

                    info.add(productname);
                    info1.add(String.valueOf(prices));
                    info2.add(String.valueOf(quantity));
                    info3.add(String.valueOf(tot));

                    //adding the values into a table
                    TableLayout table=(TableLayout)view.findViewById(R.id.tb1);
                    TableRow row= new TableRow(getActivity());
                    TextView t1=new TextView(getActivity());
                    TextView t2=new TextView(getActivity());
                    TextView t3=new TextView(getActivity());
                    TextView t4=new TextView(getActivity());

                    String total;
                    int sum=0;

                    //computation of the sum of the products
                    for(int i=0; i<info.size(); i++){
                        String pname=info.get(i);
                        String prc=info1.get(i);
                        String qty1=info2.get(i);
                        String tott=info3.get(i);

                        //input of the products into the table
                        t1.setText(pname);
                        t2.setText(prc);
                        t3.setText(qty1);
                        t4.setText(tott);

                        sum+=Integer.parseInt(info3.get(i).toString());
                    }
                    row.addView(t1);
                    row.addView(t2);
                    row.addView(t3);
                    row.addView(t4);
                    table.addView(row);

                    sub.setText(String.valueOf(sum));
                    pdname.setText("");
                    pri.setText("");
                    qty.setText("");
                    pdname.requestFocus();

                }
            }
        });
        return view;
    }
}