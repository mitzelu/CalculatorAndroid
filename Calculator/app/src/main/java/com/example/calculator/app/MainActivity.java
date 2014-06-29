package com.example.calculator.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements OnClickListener
{
    TextView result, intermediaryResult;
    String operator = " ";
    float resultNumber;
    boolean clearScreen = true;
    boolean clearDot = true;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.result);
        intermediaryResult = (TextView) findViewById(R.id.intermediaryResult);

        int ButtonsList[] = {R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5,
                             R.id.button6, R.id.button7, R.id.button8, R.id.button9, R.id.buttonCE, R.id.buttonC,
                             R.id.buttonDot, R.id.buttonDiv, R.id.buttonMul, R.id.buttonPlusMinus, R.id.buttonPar,
                             R.id.buttonAdd, R.id.buttonSub, R.id.buttonEqual};

        for (int id:ButtonsList)
        {
            Button button_id = (Button) findViewById(id);
            button_id.setOnClickListener((View.OnClickListener) this);
        }

    }

    /*public void checkZero(String text)
    {
        if (this.clearScreen)
        {
            result.setText("");
            clearScreen = false;
        }
        intermediaryResult.append(text);
    }*/

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.button0:
                intermediaryResult.append("0");
                break;

            case R.id.button1:
                intermediaryResult.append("1");
                break;

            case R.id.button2:
                intermediaryResult.append("2");
                break;

            case R.id.button3:
                intermediaryResult.append("3");
                break;

            case R.id.button4:
                intermediaryResult.append("4");
                break;

            case R.id.button5:
                intermediaryResult.append("5");
                break;

            case R.id.button6:
                intermediaryResult.append("6");
                break;

            case R.id.button7:
                intermediaryResult.append("7");
                break;

            case R.id.button8:
                intermediaryResult.append("8");
                break;

            case R.id.button9:
                intermediaryResult.append("9");
                break;

            case R.id.buttonAdd:
                operator = "+";
                intermediaryResult.append(" + ");
               // this.clearDot = true;
                break;

            case R.id.buttonSub:
                operator = "-";
                intermediaryResult.append(" - ");
               // this.clearDot = true;
                break;

            case R.id.buttonDiv:
                operator = "÷";
                intermediaryResult.append(" ÷ ");
               // this.clearDot = true;
                break;

            case R.id.buttonMul:
                operator = "x";
                intermediaryResult.append(" x ");
               // this.clearDot = true;
                break;

            case R.id.buttonDot:
                if (!intermediaryResult.getText().toString().contains(".")|| this.clearDot)
                {
                    intermediaryResult.append(".");
                    this.clearDot = false;
                }
                break;

            case R.id.buttonEqual:
                String inputStr = intermediaryResult.getText().toString();
                String [] r = inputStr.split("\\s+");

                Float firstNumber=Float.parseFloat(r[0]);
                Float secondNumber=Float.parseFloat(r[2]);

                if (operator.equals("+"))
                {
                    resultNumber = firstNumber + secondNumber;
                }

                if (operator.equals("-"))
                {
                    resultNumber = firstNumber - secondNumber;
                }

                if (operator.equals("÷"))
                {
                    resultNumber = firstNumber / secondNumber;
                }

                if (operator.equals("x"))
                {
                    resultNumber = firstNumber * secondNumber;
                }

                result.setText("=" + String.valueOf(resultNumber));
                this.clearScreen = true;
                break;

            case R.id.buttonCE:
                result.setText("0");
                intermediaryResult.setText("");
                operator = " ";
                this.clearScreen = true;
                break;

            default:
                break;


        }

    }


}
