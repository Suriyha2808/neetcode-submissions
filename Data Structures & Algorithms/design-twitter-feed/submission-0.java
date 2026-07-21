
class Twitter {

    HashMap<Integer, Set<Integer>> followmap;
    HashMap<Integer, List<int[]>> tweets;
    int time = 0;

    public Twitter() {
        followmap = new HashMap<>();
        tweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new int[]{tweetId, time});
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        
        // Max-Heap: sorts by timestamp descending (newest first)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[1], a[1])
        );

        // 1. Add user's OWN last 10 tweets
        if (tweets.containsKey(userId)) {
            List<int[]> userTweets = tweets.get(userId);
            int start = Math.max(0, userTweets.size() - 10);
            for (int i = userTweets.size() - 1; i >= start; i--) {
                maxHeap.add(userTweets.get(i));
            }
        }

        // 2. Add followees' last 10 tweets
        if (followmap.containsKey(userId)) {
            for (int followeeId : followmap.get(userId)) {
                if (tweets.containsKey(followeeId)) {
                    List<int[]> userTweets = tweets.get(followeeId);
                    int start = Math.max(0, userTweets.size() - 10);
                    for (int i = userTweets.size() - 1; i >= start; i--) {
                        maxHeap.add(userTweets.get(i));
                    }
                }
            }
        }

        // 3. Extract top 10 most recent tweets
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            ans.add(maxHeap.poll()[0]); // [0] is tweetId
            count++;
        }

        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        
        followmap.putIfAbsent(followerId, new HashSet<>());
        followmap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        
        // Prevents NullPointerException if followerId doesn't exist in map
        if (followmap.containsKey(followerId)) {
            followmap.get(followerId).remove(followeeId);
        }
    }
}