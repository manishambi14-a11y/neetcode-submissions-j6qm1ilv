
class Twitter {

    static class Tweet {
        int id;
        int time;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    HashMap<Integer, ArrayList<Tweet>> tweets;
    HashMap<Integer, HashSet<Integer>> userStore;
    int time;

    public Twitter() {
        tweets = new HashMap<>();
        userStore = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId, time++));
    }

    public List<Integer> getNewsFeed(int userId) {
        ArrayList<Tweet> allTweets = new ArrayList<>();

        // own tweets
        if (tweets.containsKey(userId)) {
            allTweets.addAll(tweets.get(userId));
        }

        // followees tweets
        if (userStore.containsKey(userId)) {
            for (int followee : userStore.get(userId)) {
                if (tweets.containsKey(followee)) {
                    allTweets.addAll(tweets.get(followee));
                }
            }
        }

        // sort by most recent
        Collections.sort(allTweets, (a, b) -> b.time - a.time);

        // pick top 10
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < Math.min(10, allTweets.size()); i++) {
            res.add(allTweets.get(i).id);
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            userStore.putIfAbsent(followerId, new HashSet<>());
            userStore.get(followerId).add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (userStore.containsKey(followerId)) {
            userStore.get(followerId).remove(followeeId);
        }
    }
}