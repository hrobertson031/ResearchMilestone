package com.example.her2.researchmilestone;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.graphics.*;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout;
public class MainActivity extends AppCompatActivity {

    private ConstraintLayout rootLayout;
    private TextView textViewTitle;
    private ImageView imageView;
    private TextView PixText;
    private TextView PixNum;
    private Palette.Swatch Vibrant;
    private Palette.Swatch Muted;
    private Palette.Swatch Dark_Vibrant;
    private Palette.Swatch Light_Vibrant;
    private Palette.Swatch Light_Muted;
    private Palette.Swatch Dark_Muted;

    private int switchNum =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public Palette createPaletteSync(Bitmap bitmap)
    {
        Palette p = Palette.from(bitmap).generate();
        return p;
    }

    private Palette.Swatch checkVibrantSwatch(Palette p)
    {
        Palette.Swatch vibrant = p.getVibrantSwatch();
        if (vibrant != null)
        {
            return vibrant;
        }
        return null;
    }
    public void createPaletteAsync(Bitmap bitmap)
    {
        Palette.from(bitmap).maximumColorCount(32).generate(new Palette.PaletteAsyncListener()
        {
            @Override
            public void onGenerated(Palette p)
            {

                Vibrant = p.getVibrantSwatch();
                Muted= p.getMutedSwatch();
                Dark_Vibrant= p.getDarkVibrantSwatch();
                Light_Vibrant = p.getLightVibrantSwatch();
                Light_Muted = p.getLightMutedSwatch();
                Dark_Muted = p.getDarkMutedSwatch();
            }
        });


    }
    public void nextSwatch(View view)
    {
        int temp = 0;
        int tempPop = 0;
        Palette.Swatch color = null;
        switch(switchNum)
        {
            case 0:
                color = Vibrant;
                temp = Vibrant.getRgb();
                textViewTitle.setText(temp);
                tempPop = Vibrant.getPopulation();
                PixNum.setText(tempPop);
                break;
            case 1:
                color = Muted;
                temp = Muted.getRgb();
                textViewTitle.setText(temp);
                tempPop = Muted.getPopulation();
                PixNum.setText(tempPop);
                break;
            case 2:
                color = Dark_Muted;
                temp = Dark_Muted.getRgb();
                textViewTitle.setText(temp);
                tempPop = Dark_Muted.getPopulation();
                PixNum.setText(tempPop);
                break;
            case 3:
                color = Dark_Vibrant;
                temp = Dark_Vibrant.getRgb();
                textViewTitle.setText(temp);
                tempPop = Dark_Vibrant.getPopulation();
                PixNum.setText(tempPop);
                break;
            case 4:
                color = Light_Muted;
                temp = Light_Muted.getRgb();
                textViewTitle.setText(temp);
                tempPop = Light_Muted.getPopulation();
                PixNum.setText(tempPop);
                break;
            case 5:
                color = Light_Vibrant;
                temp = Light_Vibrant.getRgb();
                textViewTitle.setText(temp);
                tempPop = Light_Muted.getPopulation();
                PixNum.setText(tempPop);
                break;

        }
        if(color == null)
        {
            rootLayout.setBackgroundColor(Color.GRAY);
            textViewTitle.setTextColor(Color.BLACK);
            PixText.setTextColor(Color.CYAN);
            PixNum.setTextColor(Color.CYAN);
        }
        else {
            rootLayout.setBackgroundColor(color.getRgb());
            textViewTitle.setTextColor(color.getTitleTextColor());
            PixNum.setTextColor(color.getBodyTextColor());
            PixText.setTextColor(color.getBodyTextColor());
        }
    }
}
