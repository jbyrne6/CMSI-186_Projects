/*****************************************************************************************************************************************************************************************************************************
File Name: README_Instructions.txt
Author: James Byrne
Date Last Updated: 4/3/2017
Class: 186
Project Name: Soccer Simulator
Purpose: Simulate balls being kicked and see if they collide.
*****************************************************************************************************************************************************************************************************************************/

fx = Field x dimension size
fy = Field y dimension size
bx = ball x starting point in feet
by = ball y starting point in feet
d = direction of ball in degrees (0-360 including)
v = velocity of ball in feet per second
ts = if greater than equal to 1 (time in seconds between update status), if less than 1 (1/ts updates per second)
*ts will default to 1 second if left blank

Inputs for 1 ball:
(fx, fy, bx, by, d, v, ts)

Inputs for n balls:
(fx,fy,b1x,b1y,d1,v1,b2x,b2y,d2,v2,.....,bnx,bny,dn,vn,ts)

Example input:
500x500 field with a ball starting at 0,10 with direction 35 deg and velocity 7ft/sec ,and a ball at 20,20 with direction 270 deg and velocity 23ft/sec and a status update every 5 sec.
java SoccerSim 500 500 0 10 35 7 20 20 270 23 5