package Charl12_gb.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class calculator extends AppCompatActivity {

    private int val1 = 0;
    private int val2 = 0;
    private String operation = "";
    private boolean isOp1 = true;
    private boolean dec = false;
    private boolean cal = false;
    private double dec1 = 0.0;
    private double dec2 = 0.0;
    private double resultat;
    private TextView ecran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        ecran = findViewById(R.id.screen);
    }
    private void afficher(){
        if(!isOp1){ ecran.setText(String.valueOf(val1) +" "+operation+" "+String.valueOf(val2)); }
        else{
            if(cal == true){
                ecran.setText( String.valueOf(resultat) );
            }else{
                ecran.setText( String.valueOf(val1) );
            }
        }
    }

    public void setOperation(View v){
        switch( v.getId() ){
            case R.id.btnPlus   :   operation = "+"; break;
            case R.id.btnMoins  :   operation = "-"; break;
            case R.id.btnDiv    :   operation = "/"; break;
            case R.id.btnFois   :   operation = "*"; break;
            case R.id.btnMod    :   operation = "%"; break;
            default:
                return; //Ne retourne rien
        }
        isOp1 = false;
        afficher();
    }

    public void ajouterChiffre(View v){
        int val = Integer.parseInt(((Button)v).getText().toString());
        if(!isOp1){
            val2 = val2 * 10 + val;
            afficher();
        }else {
            val1 = val1 * 10 + val;
            afficher();
        }
    }

    public  void calculer(View view){
        if(!isOp1){
            switch (operation){
                case "+"    :   resultat = (double)val1 + (double)val2; break;
                case "-"    :   resultat = (double)val1 - (double)val2; break;
                case "*"    :   resultat = (double)val1 * (double)val2; break;
                case "/"    :   resultat = (double)val1 / (double)val2; break;
                case "%"    :   resultat = (double)val1 % (double)val2; break;
                default:
                    return;
            }
            val2 = 0;
            cal = true;
            isOp1 = true;
            afficher();
        }
    }
    public  void effacer(View view){
        val1 = 0;
        val2 = 0;
        operation = "";
        isOp1 = true;
        resultat = 0;
        cal = false;
        afficher();
    }

    public void ValDecimal(View view){
        if(dec == false){
//            if(isOp1){
//                dec1 = val1 * 10 + (double)(val1/10);
//            } else {
//                dec2 = val2 * 10 + (double)(val2/10);
//            }
        }
        dec = true;
        afficher();
    }

    public void plusMoins(View view){
        if(isOp1){
            val1 = val1 * (-1);
        }else{val2 = val2 * 1;}
        afficher();
    }
}