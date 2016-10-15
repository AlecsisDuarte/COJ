#include <stdio.h>
/*
No terminada, el resultado no da cuando son mas de 3
*/
int main(){
  short n;
  scanf("%hi",&n);
  while(n--){
    short l,i=0,s=0;
    scanf("%hi",&l);
    while(--l){
      short m;
      scanf("%hi",&m);
        s+=(m-(++i));
      printf("%hi\n",s );
    }
    printf("Optimal train swapping takes %hi swaps.\n",s);
  }
  return 0;
}
