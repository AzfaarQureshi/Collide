package com.example.collidegame;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


@SuppressWarnings("deprecation")
public class GameActivity extends ActionBarActivity {
	
	Boolean gameOverCalled, BallRight, BallLeft;
    Integer scoreValue;
	final Handler h = new Handler();
	RelativeLayout layout;
	Button playBtn, retryBtn;
	TextView scoreOnBoard, highscoreOnBoard, score;
	ImageView ball, gameOver, scoreBoard, logo, pillar1, pillar2, pillar3, pillar4, pillar5, pillar6, pillar7, pillar8, pillar9, pillar10; 

	@Override
	protected void onCreate(Bundle savedInstanceState) { /* this is where everything goes. its like the main method*/
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		onCreateNew();
		
		playBtn.setOnClickListener(new View.OnClickListener(){ /*what to do when the playBtn is clicked*/
			@Override public void onClick(View v){ /* Necessary because onClick by default does nothing*/
				playBtnClicker(); //handles on changing visibility and setting the game up
				movement(); //handles how the game works
			}
		});
		
	}
	
	protected void onCreateNew(){
		
		layout = (RelativeLayout)findViewById(R.id.layout);
		playBtn = (Button)findViewById(R.id.playBtn);
		retryBtn = (Button)findViewById(R.id.retryBtn);
		scoreOnBoard = (TextView)findViewById(R.id.scoreOnBoard);
		highscoreOnBoard = (TextView)findViewById(R.id.highScoreOnBoard);
		score = (TextView)findViewById(R.id.score);
		ball = (ImageView)findViewById(R.id.ball);
		gameOver = (ImageView)findViewById(R.id.gameOver);
		scoreBoard = (ImageView)findViewById(R.id.scoreBoard);
		logo = (ImageView)findViewById(R.id.logo);
		pillar1 = (ImageView)findViewById(R.id.pillar1);
		pillar2 = (ImageView)findViewById(R.id.pillar2);
		pillar3 = (ImageView)findViewById(R.id.pillar3);
		pillar4 = (ImageView)findViewById(R.id.pillar4);
		pillar5 = (ImageView)findViewById(R.id.pillar5);
		pillar6 = (ImageView)findViewById(R.id.pillar6);
		pillar7 = (ImageView)findViewById(R.id.pillar7);
		pillar8 = (ImageView)findViewById(R.id.pillar8);
		pillar9 = (ImageView)findViewById(R.id.pillar9);
		pillar10 = (ImageView)findViewById(R.id.pillar10);
		
		gameOverCalled = false;
		BallRight = true;
		scoreValue = 0;
		
		pillar1.setVisibility(View.INVISIBLE);
		pillar2.setVisibility(View.INVISIBLE);
		pillar3.setVisibility(View.INVISIBLE);
		pillar4.setVisibility(View.INVISIBLE);
		pillar5.setVisibility(View.INVISIBLE);
		pillar6.setVisibility(View.INVISIBLE);
		pillar7.setVisibility(View.INVISIBLE);
		pillar8.setVisibility(View.INVISIBLE);
		pillar9.setVisibility(View.INVISIBLE);
		pillar10.setVisibility(View.INVISIBLE);
		ball.setVisibility(View.INVISIBLE);
		gameOver.setVisibility(View.INVISIBLE);
		retryBtn.setVisibility(View.INVISIBLE);
		scoreBoard.setVisibility(View.INVISIBLE);
		scoreOnBoard.setVisibility(View.INVISIBLE);
		highscoreOnBoard.setVisibility(View.INVISIBLE);
	}
	
	protected void playBtnClicker(){ /* custom function, sets everything to visible after play button is clicked 
	and implements all the pillar placement functions
	*/
		logo.setVisibility(View.INVISIBLE);
		playBtn.setVisibility(View.INVISIBLE);
		
		pillar1.setX(320);
		pillar1.setY(768);
		ball.setX(330);
		ball.setY(820);
		pillar2.setX(pillar1.getX() + 78);
		pillar2.setY(pillar1.getY() - 55);
		pillar3.setX(pillar2.getX() + 78);
		pillar3.setY(pillar2.getY() - 55);
		pillar4.setX(pillarPlacementX(pillar3.getX()));
		pillar4.setY(pillarPlacementY(pillar3.getY()));
		pillar5.setX(pillarPlacementX(pillar4.getX()));
		pillar5.setY(pillarPlacementY(pillar4.getY()));
		pillar6.setX(pillarPlacementX(pillar5.getX()));
		pillar6.setY(pillarPlacementY(pillar5.getY()));
		pillar7.setX(pillarPlacementX(pillar6.getX()));
		pillar7.setY(pillarPlacementY(pillar6.getY()));
		pillar8.setX(pillarPlacementX(pillar7.getX()));
		pillar8.setY(pillarPlacementY(pillar7.getY()));
		pillar9.setX(pillarPlacementX(pillar8.getX()));
		pillar9.setY(pillarPlacementY(pillar8.getY()));
		pillar10.setX(pillarPlacementX(pillar9.getX()));
		pillar10.setY(pillarPlacementY(pillar9.getY()));
		
		pillar1.setVisibility(View.VISIBLE);
		pillar2.setVisibility(View.VISIBLE);
		pillar3.setVisibility(View.VISIBLE);
		pillar4.setVisibility(View.VISIBLE);
		pillar5.setVisibility(View.VISIBLE);
		pillar6.setVisibility(View.VISIBLE);
		pillar7.setVisibility(View.VISIBLE);
		pillar8.setVisibility(View.VISIBLE);
		pillar9.setVisibility(View.VISIBLE);
		pillar10.setVisibility(View.VISIBLE);
		ball.setVisibility(View.VISIBLE);	
	}
	
	public void movement(){
		final int delay = 45;
		
		h.postDelayed(new Runnable(){ /* creates a timer and will run everything thats in the public void run, once per delay cycle*/
			public void run(){
				
				layout.setOnTouchListener(new View.OnTouchListener(){ //checks for touch type
					@Override public boolean onTouch(View v, MotionEvent event) {
					
					
					if(event.getAction() == MotionEvent.ACTION_UP){ //if the touch was 'tap screen' then do this

						if(gameOverCalled == false ){
							scoreValue++;
							score.setText(String.valueOf(scoreValue));
							if(BallRight == true){
								BallRight = false;
							} else {
								BallRight = true;
							}
						}
						return true;
					}
					return false;
				}
				}); 
				
				if(BallRight == true){
					ball.setX(ball.getX() + 6.7f);
					ball.setY(ball.getY() - 0.5f);
				} else {
					ball.setX(ball.getX() - 6.7f);
					ball.setY(ball.getY() - 0.5f);
				}
				pillar1.setY(pillar1.getY() + 5);
				pillar2.setY(pillar2.getY() + 5);
				pillar3.setY(pillar3.getY() + 5);
				pillar4.setY(pillar4.getY() + 5);
				pillar5.setY(pillar5.getY() + 5);
				pillar6.setY(pillar6.getY() + 5);
				pillar7.setY(pillar7.getY() + 5);
				pillar8.setY(pillar8.getY() + 5);
				pillar9.setY(pillar9.getY() + 5);
				pillar10.setY(pillar10.getY() + 5);
				ball.setY(ball.getY() + 0.5f); /* this counter acts the stuff in the if else bracket, so it looks like the ball is moving diagonally*/
				
				if(checkPillarPosition(pillar1.getY()) == true){ /* if pillar is at the bottom of the screen, it moves it to the top*/
					pillar1.setX(pillarPlacementX(pillar10.getX()));
					pillar1.setY(pillarPlacementY(pillar10.getY()));
				} else if (checkPillarPosition(pillar2.getY()) == true){
					pillar2.setX(pillarPlacementX(pillar1.getX()));
					pillar2.setY(pillarPlacementX(pillar1.getY()));
				} else if(checkPillarPosition(pillar3.getY()) == true){
					pillar3.setX(pillarPlacementX(pillar2.getX()));
					pillar3.setY(pillarPlacementX(pillar2.getY()));
				} else if (checkPillarPosition(pillar4.getY()) == true){
					pillar4.setX(pillarPlacementX(pillar3.getX()));
					pillar4.setY(pillarPlacementX(pillar3.getY()));
				} else if (checkPillarPosition(pillar5.getY()) == true){
					pillar5.setX(pillarPlacementX(pillar4.getX()));
					pillar5.setY(pillarPlacementX(pillar4.getY()));
				} else if (checkPillarPosition(pillar6.getY()) == true){
					pillar6.setX(pillarPlacementX(pillar5.getX()));
					pillar6.setY(pillarPlacementX(pillar5.getY()));
				} else if (checkPillarPosition(pillar7.getY()) == true){
					pillar7.setX(pillarPlacementX(pillar6.getX()));
					pillar7.setY(pillarPlacementX(pillar6.getY()));
				} else if (checkPillarPosition(pillar8.getY()) == true){
					pillar8.setX(pillarPlacementX(pillar7.getX()));
					pillar8.setY(pillarPlacementX(pillar7.getY()));
				} else if(checkPillarPosition(pillar9.getY())== true){
					pillar9.setX(pillarPlacementX(pillar8.getX()));
					pillar9.setY(pillarPlacementX(pillar8.getY()));
				} else if (checkPillarPosition(pillar10.getY()) == true){
					pillar10.setX(pillarPlacementX(pillar9.getX()));
					pillar10.setY(pillarPlacementX(pillar9.getY()));
				}
								
				h.postDelayed(this, delay);
			}
		}, delay);
	} /* where movement function ends*/
	
	public static void sendViewToBack(final View child){
		
	}
	public boolean checkPillarPosition(float Y){ /*checks to see if the pillar is right at the bottom edge of the screen*/
		boolean low;
		
		if(Y > 900f){
			low = true;
		} else {
			low= false;
		}
		return low;
	}
	
	public float pillarPlacementX(float x){
		float PillarNewX = 0f;
		int random = (int)(Math.random() * 2 + 1); // generates a number in between 1 and 2
		if(random == 1){
			if(x > 600){ /*if its nearing the edge of the screen, go the other way*/
				PillarNewX = x - 79;
			}	else {
				PillarNewX = x + 78;
			}
		} else {
			if(x < 40){ /*if its nearing the edge of the screen, go the other way*/
				PillarNewX = x + 78;
			}	else {
				PillarNewX = x - 79;
			}
		}
		
		return PillarNewX;
	}
	
	public float pillarPlacementY(float Y){ /*y always decreases so that the pillars can move up*/
		Y -= 57;
		return Y;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	

}
