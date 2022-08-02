package GraphDFSBFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, 
 * and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both 
accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name.
A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest
of the elements are emails in sorted order. The accounts themselves can be returned in any order.

Example 1:
Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
Explanation:
The first and second John's are the same person as they have the common email "johnsmith@mail.com".
The third John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 */

public class Mid721AccountsMerge {

	public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //build graph - of all email relations
        //build emailToName - build the relation between - name & emails
        //dfs to get the result
        
        //1 - build graph - 1-email connection 2-mailToName
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        buildGraph(graph, emailToName, accounts);
        /*
        for(String s : graph.keySet()) {
            System.out.println(s + "a" + graph.get(s));
        }
        */

        //2 - generate list - using graph & dfs & visited set
        List<List<String>> res = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        
        for(String email : emailToName.keySet()) {
            //System.out.println(emailToName.get(email));
            if(visited.add(email)) {
                //如果没有装进去过 - 则把跟这个名字相关的所有email都通过dfs扫进去
                List<String> list = new ArrayList<>();
                list.add(email);
                dfs(graph, list, email, visited);
                Collections.sort(list);// 3 - sort
                list.add(0, emailToName.get(email));
                res.add(list);
            }
        }
        return res;
    }
    
    private void dfs(Map<String, Set<String>> graph, List<String> list, String email,  Set<String> visited) {
        if(/*!visited.add(email) ||*/ graph.get(email).size() == 0 ||graph.get(email) == null) {
            return;
        }
        
        for(String e : graph.get(email)/*.keySet()*/) {
            if(visited.add(e)) {
                list.add(e);
                dfs(graph, list, e, visited);
            }
        }
    }
    
    private void buildGraph(Map<String, Set<String>> graph, Map<String, String> emailToName, List<List<String>> accounts) {
        for(List<String> list : accounts) {
            String name = list.get(0);
            //System.out.println(list.get(0));
            
            for(int i = 1; i < list.size(); i++) { //如果是这样 - 那mary那个test case则没法走 - 从1开始 然后<1 - 不成立
                //emailToName map
                String cur = list.get(i);
                emailToName.put(cur, name);
                graph.putIfAbsent(cur, new HashSet<>());
                
                //graph - email connections
                if(i == 1) continue;
                String pre = list.get(i - 1);
                graph.putIfAbsent(pre, new HashSet<>());
                graph.get(pre).add(cur);
                graph.get(cur).add(pre);
            }
        }
    }
}