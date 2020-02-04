
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Prasanna
 */
public class sample {
 public static void main(String args[]){
     
 }
int main()
{
    int i,j,n,x,y;
    System.out.println("How many values ?");
    Scanner sc= new Scanner(System.in);
    n=sc.nextInt();
    Map< Integer,Integer> hm = new HashMap< Integer,Integer>(); 
    System.out.println("How many values ?");
    for(i=0;i<n;i++)
    {
        j=sc.nextInt();
        if(hm.containsKey(j))
        {
            mp[j]++;
        }
        else
        {
            mp[j]=1;
        }
    }
    n=mp.size();
     vector<pair<int,long long int> > dp(mp.size()+1);
     dp[0].first=0;
    dp[0].second=0;
    for(it=mp.begin(),i=1;it!=mp.end();i++,it++)
    {
        dp[i].first=it->first;
 
        x=it->first;
        y=it->second;
 
        dp[i].second=x*y;
    }
     for(i=2;i<=n;i++)
    {
        j=i-1;
 
        if(dp[i].first==(dp[j].first+1))
        {
            j--;
        }
        dp[i].second+=dp[j].second;
         dp[i].second=max(dp[i].second,dp[i-1].second);
    }
     cout<<"The answer is "<<dp[n].second<<endl;
}
}