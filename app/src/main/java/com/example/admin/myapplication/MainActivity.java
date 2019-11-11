package com.example.admin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.admin.myapplication.Activity.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.imgSplashLogo)
    ImageView imglogo;

    @BindView(R.id.mainlayout)
    LinearLayout linearLayout;

    Animation uptodown,downtoup;

    Thread splashTread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        //getResources().getDrawable(R.drawable.citybg).setAlpha(150);

        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);


        Animation animation = AnimationUtils.loadAnimation(this,R.anim.alpha);
        animation.reset();
        linearLayout.clearAnimation();
        linearLayout.startAnimation(animation);

        Animation translate = AnimationUtils.loadAnimation(this,R.anim.bounce);
        translate.reset();
        imglogo.clearAnimation();
        imglogo.startAnimation(translate);

        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 3500) {
                        sleep(100);
                        waited += 100;
                    }
                    Intent intent = new Intent(MainActivity.this,
                            LoginActivity.class);
                    startActivity(intent);
                    MainActivity.this.finish();
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    MainActivity.this.finish();
                }

            }
        };
        splashTread.start();
    }
}
