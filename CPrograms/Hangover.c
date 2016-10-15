#include <stdio.h>
/*
WRONG ANSWERY
*/
int main(){
  float c=0;
  do{
    float i=1,n=0;
        while((n+=(1/(++i)))<=c);
    if(c)printf("%d card(s)\n",(int)(i-1));
    scanf("%f",&c);
  }while(c);
  return 0;
}
