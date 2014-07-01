package com.example.calculator.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.math.BigDecimal;

public class MainActivity extends ActionBarActivity implements OnClickListener
{
    TextView result, intermediaryResult;
    String operator = " ";
    BigDecimal resultNumber;
    int clearScreen = 1;
    boolean clearDot = true;
    int nrOfOperators;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.result);
        intermediaryResult = (TextView) findViewById(R.id.intermediaryResult);

        int ButtonsList[] = {R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5,
                             R.id.button6, R.id.button7, R.id.button8, R.id.button9, R.id.buttonCE, R.id.buttonC,
                             R.id.buttonDot, R.id.buttonDiv, R.id.buttonMul, R.id.buttonPercent, R.id.buttonPow,
                             R.id.buttonAdd, R.id.buttonSub, R.id.buttonEqual};

        for (int id:ButtonsList)
        {
            Button button_id = (Button) findViewById(id);
            button_id.setOnClickListener((View.OnClickListener) this);
        }
    }

    public void setOperator(String text)
    {
        switch (clearScreen)
        {
            case 0:
            {
                 if (!result.getText().toString().contains("Inf"))
                {
                    intermediaryResult.setText("");
                    result.setText("");
                    intermediaryResult.setText(String.valueOf(resultNumber));
                    intermediaryResult.append(text);
                    clearScreen = 1;
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Invalid operation", Toast.LENGTH_SHORT).show();
                    clearScreen = 0;
                    break;
                }

                break;
            }

            case 1:
            {
                String lastChar = intermediaryResult.getText().toString().substring(intermediaryResult.getText().toString().length()-1,intermediaryResult.getText().toString().length());

                if (intermediaryResult.getText().toString().matches("(.*)[-+÷x^](.*)")&& !lastChar.matches("^[\\d.]+$"))
                {
                    String Replace = intermediaryResult.getText().toString().substring(0,intermediaryResult.getText().toString().length()-1);
                    intermediaryResult.setText(Replace);
                    intermediaryResult.append(text);
                }
                if (!intermediaryResult.getText().toString().matches("(.*)[-+÷x^](.*)")&& lastChar.matches("^[\\d.]+$"))
                {
                        intermediaryResult.append(text);
                }
                break;
            }

            default:
                break;
        }

    }

    public void setNumber(String number)
    {
        switch(clearScreen)
        {
            case 0:
                result.setText("");
                intermediaryResult.setText("");
                clearScreen = 1;
                break;

            default:
                break;
        }

        intermediaryResult.append(number);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId()) {
            case R.id.button0:
                setNumber("0");
                break;

            case R.id.button1:
                 setNumber("1");
                break;

            case R.id.button2:
                setNumber("2");
                break;

            case R.id.button3:
                setNumber("3");
                break;

            case R.id.button4:
                setNumber("4");
                break;

            case R.id.button5:
                setNumber("5");
                break;

            case R.id.button6:
                setNumber("6");
                break;

            case R.id.button7:
                setNumber("7");
                break;

            case R.id.button8:
                setNumber("8");
                break;

            case R.id.button9:
                setNumber("9");
                break;

            case R.id.buttonAdd:
                operator = "+";
                setOperator("+");
                this.clearDot = true;
                break;

            case R.id.buttonSub:
                operator = "-";
                setOperator("-");
                this.clearDot = true;
                break;

            case R.id.buttonDiv:
                operator = "÷";
                setOperator("÷");
                this.clearDot = true;
                break;

            case R.id.buttonMul:
                operator = "x";
                setOperator("x");
                this.clearDot = true;
                break;

            case R.id.buttonPercent:
                operator = "%";
                setOperator("%");
                this.clearDot = true;
                break;

            case R.id.buttonPow:
                operator = "^";
                setOperator("^");
                this.clearDot = true;
                break;

            case R.id.buttonDot:

                if (!intermediaryResult.getText().toString().contains(".") || this.clearDot)
                {
                    intermediaryResult.append(".");
                    this.clearDot = false;
                }
                break;

            case R.id.buttonEqual:

                String inputStr = intermediaryResult.getText().toString();

                    String [] r = inputStr.split("[-+÷x^]");

                    BigDecimal firstNumber = new BigDecimal(r[0]);
                    BigDecimal secondNumber = new BigDecimal(r[1]);
                    BigDecimal zeroException = new BigDecimal("0");

                    if (operator.equals("+"))
                    {
                        resultNumber = firstNumber.add(secondNumber);
                    }

                    if (operator.equals("-"))
                    {
                        resultNumber = firstNumber.subtract(secondNumber);
                    }

                    if (operator.equals("÷"))
                    {
                        if (secondNumber.compareTo(zeroException) == 0)
                        {
                            result.setText("Infinity");
                            this.clearScreen = 0;
                            break;
                        }
                        else
                        {
                            resultNumber = firstNumber.divide(secondNumber);
                        }

                    }

                    if (operator.equals("x"))
                    {
                        resultNumber = firstNumber.multiply(secondNumber);
                    }

                   /* if (operator.equals("%"))
                    {
                        resultNumber = firstNumber % secondNumber;
                    }*/

                    if (operator.equals("^"))
                    {
                        int sec = secondNumber.intValue();
                        resultNumber = firstNumber.pow(sec);
                    }

                    result.setText("=" + String.valueOf(resultNumber));
                    this.clearScreen = 0;

                     break;

            case R.id.buttonC:
                result.setText("");
                intermediaryResult.setText("");
                //operator = " ";
                this.clearScreen = 1;
                nrOfOperators = 0;
                break;

            case R.id.buttonCE:

                if(intermediaryResult.getText().toString().length() < 1 || result.getText().toString().length() > 1)
                {
                    intermediaryResult.setText("");
                    result.setText("");
                    this.clearScreen = 1;
                    nrOfOperators = 0;
                }
                else
                {
                    String screen_new = intermediaryResult.getText().toString().substring(0,intermediaryResult.getText().toString().length()-1);
                    intermediaryResult.setText(screen_new);
                }

                break;

            default:
                break;
        }

    }


}
