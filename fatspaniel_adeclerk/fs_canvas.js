function init_graph(gid)
{
var c=document.getElementById(gid);
var ctx=c.getContext("2d");
// draw box around canvas
ctx.moveTo(20,0);
ctx.lineTo(520,0);
ctx.lineTo(520,400);
ctx.lineTo(20,400);
ctx.lineTo(20,0);
ctx.stroke();
//var grd=ctx.createLinearGradient(150,0,180,0);
//grd.addColorStop(0,"black");
//grd.addColorStop(1,"yellow");

// Fill with gradient
//ctx.fillStyle=grd;
//    ctx.fillRect(20,20,500,380);
//draw ticks

// 0
ctx.moveTo(20,390);
ctx.lineTo(15,390);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("0",0,395);

// 5
ctx.moveTo(20,370);
ctx.lineTo(15,370);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("5",0,375);

// 10
ctx.moveTo(20,350);
ctx.lineTo(15,350);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("10",0,355);

// 15
ctx.moveTo(20,330);
ctx.lineTo(15,330);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("15",0,335);

// 20
ctx.moveTo(20,310);
ctx.lineTo(15,310);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("20",0,315);

// 25
ctx.moveTo(20,290);
ctx.lineTo(15,290);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("25",0,295);

// 30
ctx.moveTo(20,270);
ctx.lineTo(15,270);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("30",0,275);

// 35
ctx.moveTo(20,250);
ctx.lineTo(15,250);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("35",0,255);

// 40
ctx.moveTo(20,230);
ctx.lineTo(15,230);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("40",0,235);

// 45
ctx.moveTo(20,210);
ctx.lineTo(15,210);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("45",0,215);

// 50
ctx.moveTo(20,190);
ctx.lineTo(15,190);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("50",0,195);

// 55
ctx.moveTo(20,170);
ctx.lineTo(15,170);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("55",0,175);

// 60
ctx.moveTo(20,150);
ctx.lineTo(15,150);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("60",0,155);

// 65
ctx.moveTo(20,130);
ctx.lineTo(15,130);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("65",0,135);

//  70
ctx.moveTo(20,110);
ctx.lineTo(15,110);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("70",0,115);


// 75
ctx.moveTo(20,90);
ctx.lineTo(15,90);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("75",0,95);

// draw hour lines

// 00:00
ctx.moveTo(40,410);
ctx.lineTo(40,400);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("00",35,420);

// 01:00
ctx.moveTo(60,410);
ctx.lineTo(60,400);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("01",55,420);

// 02:00
ctx.moveTo(80,410);
ctx.lineTo(80,400);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("02",75,420);

// 03:00
ctx.moveTo(100,410);
ctx.lineTo(100,400);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("03",95,420);

// 04:00
ctx.moveTo(120,410);
ctx.lineTo(120,400);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("04",115,420);

// 05:00
ctx.moveTo(140,410);
ctx.lineTo(140,400);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("05",135,420);

// 06:00
ctx.moveTo(160,410);
ctx.lineTo(160,400);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("06",155,420);

// 07:00
ctx.moveTo(180,410);
ctx.lineTo(180,400);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("07",175,420);

// 08:00
ctx.moveTo(200,410);
ctx.lineTo(200,400);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("08",195,420);

// 09:00
ctx.moveTo(220,410);
ctx.lineTo(220,400);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("09",215,420);

// 10:00
ctx.moveTo(240,410);
ctx.lineTo(240,400);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("10",235,420);

// 11:00
ctx.moveTo(260,410);
ctx.lineTo(260,400);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("11",255,420);

// 12:00
ctx.moveTo(280,410);
ctx.lineTo(280,400);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("12",275,420);

// 13:00
ctx.moveTo(300,410);
ctx.lineTo(300,400);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("13",295,420);

// 14:00
ctx.moveTo(320,410);
ctx.lineTo(320,400);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("14",315,420);

// 15:00
ctx.moveTo(340,410);
ctx.lineTo(340,400);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("15",335,420);

// 16:00
ctx.moveTo(360,410);
ctx.lineTo(360,400);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("16",355,420);

// 17:00
ctx.moveTo(380,410);
ctx.lineTo(380,400);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("17",375,420);

// 18:00
ctx.moveTo(400,410);
ctx.lineTo(400,400);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("18",395,420);

// 19:00
ctx.moveTo(420,410);
ctx.lineTo(420,400);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("19",415,420);

// 20:00
ctx.moveTo(440,410);
ctx.lineTo(440,400);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("20",435,420);

// 21:00
ctx.moveTo(460,410);
ctx.lineTo(460,400);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("21",455,420);

// 22:00
ctx.moveTo(480,410);
ctx.lineTo(480,400);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("22",475,420);

// 23:00
ctx.moveTo(500,410);
ctx.lineTo(500,400);
ctx.stroke();
ctx.font="10px Arial";
ctx.fillText("23",495,420);
// draw zero line
ctx.moveTo(20,390);
ctx.lineTo(520,390);
ctx.stroke();
}

function plot_point(gid, time, value)
{
var c=document.getElementById(gid);
var ctx=c.getContext("2d");
    ctx.font="10px Arial";
    var x = get_x(time);
    var y = get_y(value);
	ctx.fillText(".",x,y);
}

function connect_point(gid,time1,value1,time2,value2)
{
var x1 = get_x(time1);
var y1 = get_y(value1);
var x2 = get_x(time2);
var y2 = get_y(value2);
var c=document.getElementById(gid);
var ctx=c.getContext("2d");
    ctx.moveTo(x1,y1);
    ctx.lineTo(x2,y2);
  
    ctx.stroke();
}
function get_x(time)
{
var x;
  switch(time)
    {
    case 0:
	x = 40;
	break;
    case 1:
	x = 60;
	break;
    case 2:
	x = 80;
	break;
    case 3:
	x = 100;
	break;
    case 4:
	x = 120;
	break;
    case 5:
	x = 140;
	break;
    case 6:
	x = 160;
	break;
    case 7:
	x = 180;
	break;
    case 8:
	x = 200;
	break;
    case 9:
	x = 220;
	break;
    case 10:
	x = 240;
	break;
    case 11:
	x = 260;
	break;
    case 12:
	x = 280;
	break;
    case 13:
	x = 300;
	break;
    case 14:
	x = 320;
	break;
    case 15:
	x = 340;
	break;
    case 16:
	x = 360;
	break;
    case 17:
	x = 380;
	break;
    case 18:
	x = 400;
	break;
    case 19:
	x = 420;
	break;
    case 20:
	x = 440;
	break;
    case 21:
	x = 460;
	break;
    case 22:
	x = 480;
	break;
    case 23:
	x = 500;
	break;
    }
return x;
}
function get_y(value)
{
var y;
if( value < 0 )
    {
	y = 400;
    }
    else if( value == 0)
    {
	y = 390;
    }
    else if( value > 0 && value <= 5 )
    {
	y = 370;
	y = y - (value * 4);
    }
    else if( value > 5 && value <= 10 )
    {
	y = 350;
	y = y - ((value-5) * 4)
    }
    else if( value > 10 && value <= 15 )
    {
	y = 330;
	y = y - ((value-10) * 4);
    }
    else if( value > 15 && value <= 20 )
    {
	y = 310;
	y = y - ((value-15) * 4);
    }
    else if( value > 20 && value <= 25 )
   {
	y = 290;
       y = y - ((value-20) * 4);
    }
    else if( value > 25 && value <= 30 )
   {
	y = 270;
       y = y - ((value-25) * 4);
    }
    else if( value > 30 && value <= 35 )
   {
	y = 250;
       y = y - ((value-30) * 4);
    }
    else if( value > 35 && value <= 40 )
   {
	y = 230;
       y = y - ((value-35) * 4);
    }
    else if( value > 40 && value <= 45 )
   {
	y = 210;
       y = y - ((value-40) * 4);
    }
    else if( value > 45 && value <= 50 )
   {
	y = 190;
       y = y - ((value-45) * 4);
    }
    else if( value > 50 && value <= 55 )
   {
	y = 170;
       y = y - ((value-50) * 4);
    }
    else if( value > 55 && value <= 60 )
   {
	y = 150;
       y = y - ((value-55) * 4);
    }
    else if( value > 60 && value <= 65 )
   {
	y = 130;
       y = y - ((value-60) * 4);
    }
    else if( value > 65 && value <= 70 )
   {
	y = 110;
       y = y - ((value-65) * 4);
    }
    else if( value > 70 && value <= 75 )
   {
	y = 90;
       y = y - ((value-70) * 4);
    }
    else
    {
	y = 70;
	y = y - ((value-75) * 4);
    }
return y;
}