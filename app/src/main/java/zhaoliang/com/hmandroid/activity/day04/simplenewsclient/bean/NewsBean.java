package zhaoliang.com.hmandroid.activity.day04.simplenewsclient.bean;

import java.util.List;

/**
 * Created by zhaoliang on 2017/5/17.
 */

public class NewsBean {

    /**
     * status : ok
     * source : abc-news-au
     * sortBy : top
     * articles : [{"author":null,"title":"Memo 'shows Trump tried to shut down FBI probe' into adviser's Russia links","description":"The White House disputes a report that Donald Trump asked former FBI director James Comey to shut down an investigation into ousted national security adviser Michael Flynn.","url":"http://www.abc.net.au/news/2017-05-17/trump-asked-comey-to-shut-down-flynn-investigation:-reports/8532118","urlToImage":"http://www.abc.net.au/news/image/8532312-1x1-700x700.jpg","publishedAt":"2017-05-17T01:11:22Z"},{"author":"http://www.abc.net.au/news/rebecca-opie/6799868","title":"Salt Creek attacker with 'anger management issues' gets 22 years' jail","description":"The man convicted over a brutal assault on two young backpackers at Salt Creek is sentenced to 22 years and four months in jail.","url":"http://www.abc.net.au/news/2017-05-17/salt-creek-backpack-attacker-roman-heinze-sentenced/8532256","urlToImage":"http://www.abc.net.au/news/image/8532688-1x1-700x700.jpg","publishedAt":"2017-05-17T01:22:23Z"},{"author":null,"title":"Police considering legal advice about charges against George Pell","description":"Victoria Police consider advice from the DPP regarding charging Catholic Cardinal George Pell over historical sexual assault allegations which he denies.","url":"http://www.abc.net.au/news/2017-05-17/police-considering-legal-advice-on-george-pell/8531960","urlToImage":"http://www.abc.net.au/news/image/7185834-1x1-700x700.jpg","publishedAt":"2017-05-17T00:29:20Z"},{"author":null,"title":"Football faithful gather in Melbourne to honour 'Louie the Lip'","description":"Collingwood legend Lou Richards is remembered as a footballer with indomitable courage, a cheeky showman and loving father at his state funeral in Melbourne.","url":"http://www.abc.net.au/news/2017-05-17/lou-richards-collingwood-champion-farewelled-at-state-funeral/8532344","urlToImage":"http://www.abc.net.au/news/image/8532994-1x1-700x700.jpg","publishedAt":"2017-05-17T02:33:43Z"},{"author":null,"title":"If you cut mould off food, is it then safe to eat?","description":"How safe is mouldy food?","url":"http://www.abc.net.au/news/2017-05-17/is-it-safe-to-eat-food-after-cut-mould-off/8518220","urlToImage":"http://www.abc.net.au/news/image/8518710-1x1-700x700.jpg","publishedAt":"2017-05-17T00:20:10Z"},{"author":"http://www.abc.net.au/news/tom-iggulden/166940","title":"Bankrupt Culleton told to pay back hundreds of thousands of dollars","description":"Rod Culleton is legally required to pay back the salary he earned as a senator, plus what he paid his staff and other expenses, because the High Court found he was never eligible to run for election.","url":"http://www.abc.net.au/news/2017-05-17/rod-culleton-hit-with-debt-letter-for-senator-salary-expenses/8531936","urlToImage":"http://www.abc.net.au/news/image/8176568-1x1-700x700.jpg","publishedAt":"2017-05-16T23:19:40Z"},{"author":"http://www.abc.net.au/news/loretta-florance/5751762","title":"Renters in Sydney, Hobart feel squeeze, while rest of country remains steady","description":"Australia's spiralling house prices are putting pressure on the rental market, forcing low-income earners to the outer suburbs while potential buyers save for a deposit, a peak advocacy group says.","url":"http://www.abc.net.au/news/2017-05-17/renters-in-sydney,-hobart-feel-squeeze/8531204","urlToImage":"http://www.abc.net.au/news/image/4886468-1x1-700x700.jpg","publishedAt":"2017-05-16T20:07:49Z"},{"author":"http://www.abc.net.au/news/michael-janda/166854","title":"Wage growth remains stuck at record lows: ABS","description":"Wage growth remains at record lows in the first quarter of this year, with workers receiving a pay rise of just 0.5 per cent.","url":"http://www.abc.net.au/news/2017-05-17/wage-price-index-abs-march-quarter/8532810","urlToImage":"http://www.abc.net.au/news/image/5352938-1x1-700x700.jpg","publishedAt":"2017-05-17T02:08:35Z"},{"author":"http://www.abc.net.au/news/dan-conifer/5189074, http://www.abc.net.au/news/5511636","title":"Government urged to act after Four Corners gun smuggling revelations","description":"The Government is under pressure to pass new gun smuggling legislation after the ABC revealed a syndicate smuggled more than 130 high-powered handguns into Australia through the post.","url":"http://www.abc.net.au/news/2017-05-17/coalition-urged-to-act-after-four-corners-gun-trafficking-report/8531992","urlToImage":"http://www.abc.net.au/news/image/8522646-1x1-700x700.jpg","publishedAt":"2017-05-17T01:08:04Z"},{"author":"http://www.abc.net.au/news/carol-r%C3%A4%C3%A4bus/5527350","title":"Hobart doctor's mission to Mars","description":"Hobart doctor Alicia Tucker has always been fascinated with space, so when she got a chance to live on Mars, she had to take it.","url":"http://www.abc.net.au/news/2017-05-17/hobart-doctors-mission-to-mars/8532446","urlToImage":"http://www.abc.net.au/news/image/8531174-1x1-700x700.jpg","publishedAt":"2017-05-17T01:16:49Z"}]
     */

    private String status;
    private String source;
    private String sortBy;
    private List<ArticlesBean> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public List<ArticlesBean> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticlesBean> articles) {
        this.articles = articles;
    }

    public static class ArticlesBean {
        /**
         * author : null
         * title : Memo 'shows Trump tried to shut down FBI probe' into adviser's Russia links
         * description : The White House disputes a report that Donald Trump asked former FBI director James Comey to shut down an investigation into ousted national security adviser Michael Flynn.
         * url : http://www.abc.net.au/news/2017-05-17/trump-asked-comey-to-shut-down-flynn-investigation:-reports/8532118
         * urlToImage : http://www.abc.net.au/news/image/8532312-1x1-700x700.jpg
         * publishedAt : 2017-05-17T01:11:22Z
         */

        private Object author;
        private String title;
        private String description;
        private String url;
        private String urlToImage;
        private String publishedAt;

        public Object getAuthor() {
            return author;
        }

        public void setAuthor(Object author) {
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUrlToImage() {
            return urlToImage;
        }

        public void setUrlToImage(String urlToImage) {
            this.urlToImage = urlToImage;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }
    }
}
