package hld.twitter;

public class Twitter {
}

/*
=> Functional :
1. Tweet 280 char messages.
2. Follow other users
3. Show timeline of the users we follow
4. Mark tweets as favorite
5. Tweet can contain photo video

=> Non functional :
1. High availability
2. Low latency around 200ms for generating timeline
3. Eventual consistency.

=> Extended req:
1. Retweet
2. Comments on tweets
3. Show trending tweets
4. Tagging other users.
5. Replying to tweet
6. Tweet notification

=> capacity estimation
1B total users, Assume 200M DAU. We store 5 years of tweets permanently. 100 M new tweets every day.
Also, each user follows around 200 people.

=> Traffic

=> Storage
=> Bandwidth
=> Memory

=> High level design

=> Db choice
=> DB partitioning (Sharding)
=> Caching
=> Load balancers
=> Data replication

 */