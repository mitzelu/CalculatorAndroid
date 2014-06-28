package com.example.calculator.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements OnClickListener
{
    TextView result;
    String operator = " ";
    float resultNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.result);

        int ButtonsList[] = {R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5,
                             R.id.button6, R.id.button7, R.id.button8, R.id.button9, R.id.buttonCE, R.id.buttonC,
                             R.id.buttonDot, R.id.buttonPlusMinus, R.id.buttonPar, R.id.buttonDiv, R.id.buttonMul,
                             R.id.buttonAdd, R.id.buttonSub, R.id.buttonEqual};

        for (int id:ButtonsList)
        {
            Button button_id = (Button) findViewById(id);
            button_id.setOnClickListener((View.OnClickListener) this);
        }

    }

    public void checkZero()
    {
        if (result.equals("0"))
        {
            result.setText(" ");
        }
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.button0:
                result.append("0");
                break;

            case R.id.button1:
                checkZero();
                result.append("1");
                break;

            case R.id.button2:
                checkZero();
                result.append("2");
                break;

            case R.id.button3:
                if (result.equals("0"))
                {
                    result.setText("A");
                }
                result.append("3");
                break;

            case R.id.button4:
                checkZero();
                result.append("4");
                break;

            case R.id.button5:
                checkZero();
                result.append("5");
                break;

            case R.id.button6:
                checkZero();
                result.append("6");
                break;

            case R.id.button7:
                checkZero();
                result.append("7");
                break;

            case R.id.button8:
                checkZero();
                result.append("8");
                break;

            case R.id.button9:
                checkZero();
                result.append("9");
                break;

            case R.id.buttonAdd:
                operator = "+";
                result.append(" + ");
                break;

            case R.id.buttonSub:
                operator = "-";
                result.append(" - ");
                break;

            case R.id.buttonDiv:
                operator = "÷";
                result.append(" ÷ ");
                break;

            case R.id.buttonMul:
                operator = "x";
                result.append(" x ");
                break;

            case R.id.buttonDot:
                result.append(".");
                break;

            case R.id.buttonEqual:
                String inputStr = result.getText().toString();
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

                result.setText(String.valueOf(resultNumber));
                break;

            case R.id.buttonCE:
                result.setText("0");
                operator = " ";
                break;

            default:
                break;


        }

    }


}
