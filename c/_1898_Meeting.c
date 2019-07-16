/**
 * Problem: 1898 - Meeting
 *
 * Description:
 *  Two cyclists are travelling on a long highway along the same line, but in
 *  opposite directions. The first biker moves at a constant speed of 10 <= A <= 25
 *  km/h. The second biker at a constant speed of 10 <= B <= 25 km/h.
 *  
 *  Knowing this information, and the initial distance in kms between the cyclists
 *  (0 <= D <= 10^9), can you determine the number of hours it takes the bikers to
 *  pass each other? For the calculations, you may consider the bikers as very small
 *  points on the plane.
 *
 * Input specification:
 *  The first line contains an integer number 1 <= N <= 10^3 denoting the number
 *  of scenarios. Each of the following N lines contains three space separated
 *  integer numbers A, B and D.
 *
 * Output specification:
 *  You must print N lines. The i-th line contains the calculated hours for the
 *  i-th scenario given in the input, as a real number rounded up to four decimal
 *  places.
 *
 * Sample input:
 *  4
 *  20 20 0
 *  10 10 100
 *  20 25 900
 *  17 23 999
 *
 * Sample output:
 *  0.0000
 *  5.0000
 *  20.0000
 *  24.9750
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1898
 */
#include <stdio.h>

int main()
{
    short t;
    scanf("%hu", &t);
    while (t--)
    {
        int a, b, d;
        scanf("%d %d %d", &a, &b, &d);
        double totalSpeed = a + b;
        double res = d/totalSpeed;
        printf("%.4f\n", res);
    }

    return 0;
}
