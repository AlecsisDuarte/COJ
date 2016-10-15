#include <stdio.h>

int main(){
  int n=0,i,j,p;
  scanf("%d",&n);
  int ni[n];
  for(i=0; i<n; ++i){
      scanf("%d",&ni[i]);
  }
  for(i=0; i<n; ++i){
    for(j=i+1; j<n; ++j){
      if(ni[i]>ni[j]){
        p = ni[i];
        ni[i]=ni[j];
        ni[j]=p;
      }
    }
  }
  for(i=0; i<n; ++i){
    printf("%d\n", ni[i] );
  }
  return 0;
}
