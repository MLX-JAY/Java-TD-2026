public class Point {
int x;
int y;
Point ( int x , int y) 
{
this.x = x;
this.y = y;
}
// 1. É change classique ( avec variable temporaire )
void symetrieXY () 
{
    int c=0;
    c=x;
    x=y;
    y=c;
}
void symetrieXYPlus () 
{
    x=x+y;
    y=x-y;
    x=x-y;
}
void symetrieXYChapeau () 
{
    x=y^x;
    y=y^x;
    x=x^y;
}
String affichage () {
return "(" + this .x + ", " + this .y + ")";
}
}