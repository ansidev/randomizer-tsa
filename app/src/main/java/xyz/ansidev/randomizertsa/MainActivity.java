package xyz.ansidev.randomizertsa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView left = (ImageView) findViewById(R.id.ivArrowLeft);
        final ImageView right = (ImageView) findViewById(R.id.ivArrowRight);
        final Button btnTapHere= (Button) findViewById(R.id.btnTapHere);

        final Animation moveToLeft = new TranslateAnimation(0, -9999, 0, 0);
        final Animation moveToRight = new TranslateAnimation(0, 9999, 0, 0);
        moveToRight.setStartOffset(300);
        moveToRight.setDuration(500);
        moveToLeft.setStartOffset(300);
        moveToLeft.setDuration(500);
        left.setAnimation(moveToLeft);
        right.setAnimation(moveToRight);

        moveToRight.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                left.setVisibility(View.GONE);
                right.setVisibility(View.GONE);
                btnTapHere.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        moveToLeft.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                left.setVisibility(View.GONE);
                right.setVisibility(View.GONE);
                btnTapHere.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        btnTapHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int i = random.nextInt(2);
                btnTapHere.setVisibility(View.GONE);
                if (i == 0) {
                    left.setVisibility(View.VISIBLE);
                    left.startAnimation(moveToLeft);
                } else {
                    right.setVisibility(View.VISIBLE);
                    right.startAnimation(moveToRight);
                }
            }
        });
    }
}
