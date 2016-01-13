public class ContestTable {
    private final String[] lines;

    public ContestTable(String[] lines) {
        this.lines = lines;
    }

    public String contest() {
        int players = lines.length;
        Graph graph = new Graph(players);
        for (int m = 2; m <= players; m++) {
            char[] contests = lines[m - 1].toCharArray();
            for (int l = 1; l < contests.length; l++) { // skip ending '#'
                char contest = contests[l - 1];
                int winner = l, loser = m;
                if (contest == '+') { // if m win l
                    winner = m;
                    loser = l;
                }
                graph.arrange(winner, loser);
            }
        }

        String result = "";
        for(int i : graph.vertices){
            result += " " + i;
        }
        return result.substring(1);
    }

    private class Graph{
        private final int size;
        int[] vertices;

        public Graph(int size) {
            this.size = size;
            vertices = new int[size];
            for(int i = 0; i < size; i++){
                vertices[i] = i + 1;
            }
        }

        void arrange(int from, int to) {
            // 1
            int base = 1;
            if(to == base){
                for(int i = 2; i < size; i++) {
                    vertices[i - 1] = vertices[i];
                }
                vertices[size - 1] = from;
            }
        }
    }


}
