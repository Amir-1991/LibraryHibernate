package tag;

import entity.ArticleEntity;
import entity.TagEntity;
import repository.ArticleRepository;
import repository.TagRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TagService {

    public static void creatTag() {
        Scanner scanner = new Scanner(System.in);
        TagEntity newTag = new TagEntity();
        showSignInMessage("Tag Title");
        newTag.setTagTitle(scanner.next());
        TagRepository.save(newTag);
        System.out.println("Congratulations Your Category Has Been Created ");
    }

    public static void attachTag() {
        Scanner scanner = new Scanner(System.in);
        List<String> tagArticle = new ArrayList<>();
        List<ArticleEntity> articleList = ArticleRepository.seeAll();
        System.out.println("Row \t Article ID \t Article Title ");
        for (int artCounter = 0; artCounter < articleList.size(); artCounter++) {
            System.out.println((artCounter + 1) + ":\t \t \t" + articleList.get(artCounter).getId() + "\t \t \t \t" + articleList.get(artCounter).getTitle());
        }
        int artScan = Integer.parseInt(scanner.next());
        System.out.println("Please Enter Your Article Name Row ");
        tagArticle.add(0, String.valueOf(articleList.get(artScan - 1).getId()));
        List<TagEntity> tagList = TagRepository.seeAll();
        System.out.println("Row \t Tag ID \t Tag Title ");
        for (int tagCounter = 0; tagCounter < tagList.size(); tagCounter++) {
            System.out.println((tagCounter + 1) + ":\t \t \t" + tagList.get(tagCounter).getId() + " \t   \t " + tagList.get(tagCounter).getTagTitle());
        }
        System.out.println("Please Enter Your tag Name Available In Above List");
        int tagScan = Integer.parseInt(scanner.next());
        tagArticle.add(1, String.valueOf(articleList.get(tagScan - 1).getId()));

    }

    public static void showSignInMessage(String inputMsg) {
        System.out.println("Please Enter Your " + inputMsg);
    }
}
