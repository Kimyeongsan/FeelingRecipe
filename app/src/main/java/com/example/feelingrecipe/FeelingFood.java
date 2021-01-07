package com.example.feelingrecipe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FeelingFood {
    static final int TASTY_SWEET        = 0; //단 맛
    static final int TASTY_SPICY        = 1; //매운 맛
    static final int TASTY_PALATABLE    = 2; //느끼한 맛(고소하다고 치자)
    static final int TASTY_FRESH        = 3; //신맛, 상큼한 맛
    static final int TASTY_MIDE         = 4; //담백한 맛

    static final int HOW_ROAST          = 0; //구운 요리
    static final int HOW_FRY            = 1; //튀긴 요리
    static final int HOW_STIR_FRY       = 2; //볶음 요리
    static final int HOW_BOIL           = 3; //삶거나 찐 요리

    static final int SOURCE_PORK        = 0; //돼지
    static final int SOURCE_CHICKEN     = 1; //닭
    static final int SOURCE_KiMCHI      = 2; //김치
    //...


    boolean isHappy, isRice; //기분이 좋은지 아닌지,  면인지 밥인지
    int src[], how, tasty[]; //순서대로 재료, 방법, 맛
    public String name;

    FeelingFood(String name, boolean isHappy, int src[], int how, boolean isRice, int tasty[]){
        this.isHappy = isHappy;
        this.isRice = isRice;
        this.src = src;
        this.tasty = tasty;
        this.how = how;
        this.name = name;
    }

    static Set<String> setHashSet(int sTasty, int sSource, int sHow){
        ArrayList<FeelingFood> foods = initFoodList();

        Set<String> tastySet = new HashSet<>();
        for(FeelingFood food : foods){
            for(int tasty : food.tasty){
                if(tasty == sTasty){
                    tastySet.add(food.name);
                }
            }
        }

        Set<String> sourceSet = new HashSet<>();
        for(FeelingFood food : foods){
            for(int source : food.src){
                if(source == sSource){
                    sourceSet.add(food.name);
                }
            }
        }

        Set<String> howSet = new HashSet<>();
        for(FeelingFood food : foods){
            if(food.how == sHow){
                howSet.add(food.name);
            }
        }

        // H : how T : tasty S: source
        Set<String> HTresult = new HashSet<>();
        Set<String> HSresult = new HashSet<>();
        Set<String> STresult = new HashSet<>();

        Iterator<String> iteratorH;
        Iterator<String> iteratorS;

        iteratorH = howSet.iterator();
        while(iteratorH.hasNext()){
            String tmp = iteratorH.next();
            if(tastySet.contains(tmp))
                HTresult.add(tmp);
        }

        iteratorH = howSet.iterator();
        while(iteratorH.hasNext()){
            String tmp = iteratorH.next();
            if(sourceSet.contains(tmp))
                HSresult.add(tmp);
        }

        iteratorS = sourceSet.iterator();
        while(iteratorS.hasNext()){
            String tmp = iteratorS.next();
            if(howSet.contains(tmp))
                STresult.add(tmp);
        }

        System.out.println("How/ Tasty result : "+HTresult.toString());
        System.out.println("Source/ Tasty result : "+STresult.toString());
        System.out.println("How/ Source result : "+HSresult.toString());

        Set<String> HTSresult = new HashSet<>();

        Iterator<String> iteratorHS = HSresult.iterator();
        while(iteratorHS.hasNext()) {
            String tmp = iteratorHS.next();
            if (tastySet.contains(tmp))
                HTSresult.add(tmp);
        }
        return HTSresult;
    }

    static ArrayList<FeelingFood> initFoodList(){
        ArrayList<FeelingFood> foods = new ArrayList<>();

        int src[]={SOURCE_PORK};
        int tasty[] = {TASTY_SPICY,TASTY_SWEET};
        foods.add(new FeelingFood("제육볶음",true,src,HOW_STIR_FRY,true,tasty));


        int src_1[]={SOURCE_CHICKEN};
        int tasty_1[] = {TASTY_SWEET, TASTY_MIDE};
        foods.add(new FeelingFood("치킨스테이크",true,src_1,HOW_ROAST,true,tasty_1));


        int src_2[]={SOURCE_PORK, SOURCE_KiMCHI};
        int tasty_2[] = {TASTY_SPICY,TASTY_SWEET, TASTY_FRESH};
        foods.add(new FeelingFood("매운김치찜",false,src_2,HOW_BOIL,true,tasty_2));


        int src_3[]={SOURCE_PORK};
        int tasty_3[] = {TASTY_PALATABLE,TASTY_SWEET};
        foods.add(new FeelingFood("항정살덮밥",true,src_3,HOW_ROAST,true,tasty_3));


        int src_4[]={SOURCE_PORK};
        int tasty_4[] = {TASTY_SPICY,TASTY_SWEET, TASTY_MIDE};
        foods.add(new FeelingFood("쇠고기비빔국수",true,src_4,HOW_STIR_FRY,false,tasty_4));


        int src_5[]={SOURCE_PORK};
        int tasty_5[] = {TASTY_SWEET, TASTY_PALATABLE, TASTY_FRESH};
        foods.add(new FeelingFood("더블삼겹살",true,src_5,HOW_ROAST,true,tasty_5));


        int src_6[]={SOURCE_KiMCHI};
        int tasty_6[] = {TASTY_SWEET, TASTY_FRESH, TASTY_SPICY};
        foods.add(new FeelingFood("김치볶음밥",false,src_6,HOW_STIR_FRY,true,tasty_6));


        int src_7[]={SOURCE_PORK};
        int tasty_7[] = {TASTY_SWEET, TASTY_SPICY, TASTY_PALATABLE};
        foods.add(new FeelingFood("돼지김치찌게",false,src_7,HOW_ROAST,true,tasty_7));


        int src_8[]={SOURCE_PORK};
        int tasty_8[] = {TASTY_SWEET, TASTY_SPICY, TASTY_PALATABLE};
        foods.add(new FeelingFood("제육덮밥",true,src_8,HOW_STIR_FRY,true,tasty_8));


        int src_9[]={SOURCE_CHICKEN};
        int tasty_9[] = {TASTY_SWEET, TASTY_MIDE};
        foods.add(new FeelingFood("닭칼국수",true,src_9,HOW_BOIL,false,tasty_9));


        int src_10[]={SOURCE_CHICKEN};
        int tasty_10[] = {TASTY_SWEET, TASTY_PALATABLE};
        foods.add(new FeelingFood("삼계탕",false,src_10,HOW_BOIL,true,tasty_10));


        int src_11[]={SOURCE_PORK};
        int tasty_11[] = {TASTY_SWEET, TASTY_SPICY, TASTY_FRESH};
        foods.add(new FeelingFood("고추참치비빕면",false,src_11,HOW_STIR_FRY,false,tasty_11));


        int src_12[]={SOURCE_PORK};
        int tasty_12[] = {TASTY_SWEET, TASTY_MIDE};
        foods.add(new FeelingFood("사골돼지전골",false,src_12,HOW_BOIL,true,tasty_12));


        int src_13[]={SOURCE_CHICKEN};
        int tasty_13[] = {TASTY_SWEET,TASTY_SPICY, TASTY_MIDE};
        foods.add(new FeelingFood("춘천닭갈비",true,src_13,HOW_STIR_FRY,true,tasty_13));


        int src_14[]={SOURCE_PORK};
        int tasty_14[] = {TASTY_SWEET, TASTY_MIDE};
        foods.add(new FeelingFood("장조림 버터비빔밥",true,src_14,HOW_STIR_FRY,true,tasty_14));


        int src_15[]={SOURCE_PORK};
        int tasty_15[] = {TASTY_SWEET, TASTY_PALATABLE, TASTY_FRESH};
        foods.add(new FeelingFood("차돌박이국수",true,src_15,HOW_STIR_FRY,false,tasty_15));


        int src_16[]={SOURCE_PORK};
        int tasty_16[] = {TASTY_SWEET, TASTY_MIDE};
        foods.add(new FeelingFood("뚝배기불고기",true,src_16,HOW_STIR_FRY,true,tasty_16));


        int src_17[]={SOURCE_PORK};
        int tasty_17[] = {TASTY_SWEET, TASTY_PALATABLE};
        foods.add(new FeelingFood("고기볶음밥",true,src_17,HOW_STIR_FRY,true,tasty_17));


        int src_18[]={SOURCE_PORK};
        int tasty_18[] = {TASTY_SWEET, TASTY_PALATABLE};
        foods.add(new FeelingFood("삼겹살 김밥",true,src_18,HOW_ROAST,true,tasty_18));


        int src_19[]={SOURCE_PORK};
        int tasty_19[] = {TASTY_SWEET, TASTY_PALATABLE};
        foods.add(new FeelingFood("규카츠",true,src_19,HOW_FRY,true,tasty_19));


        int src_20[]={SOURCE_KiMCHI};
        int tasty_20[] = {TASTY_SWEET, TASTY_SPICY, TASTY_FRESH};
        foods.add(new FeelingFood("매운당면찌게",false,src_20,HOW_BOIL,true,tasty_20));


        int src_21[]={SOURCE_PORK, SOURCE_CHICKEN};
        int tasty_21[] = {TASTY_SWEET, TASTY_SPICY, TASTY_PALATABLE};
        foods.add(new FeelingFood("꽈리고추닭불고기",false,src_21,HOW_STIR_FRY,true,tasty_21));


        int src_22[]={SOURCE_KiMCHI};
        int tasty_22[] = {TASTY_SWEET, TASTY_SPICY, TASTY_MIDE};
        foods.add(new FeelingFood("닭두루치기",false,src_22,HOW_STIR_FRY,true,tasty_22));


        int src_23[]={SOURCE_KiMCHI};
        int tasty_23[] = {TASTY_SWEET, TASTY_MIDE};
        foods.add(new FeelingFood("갈릭마요치킨바베큐",true,src_23,HOW_ROAST,true,tasty_23));


        int src_24[]={SOURCE_KiMCHI};
        int tasty_24[] = {TASTY_SWEET, TASTY_SPICY};
        foods.add(new FeelingFood("닭날개꼬치",false,src_24,HOW_FRY,true,tasty_24));


        int src_25[]={SOURCE_PORK};
        int tasty_25[] = {TASTY_SWEET, TASTY_FRESH, TASTY_MIDE};
        foods.add(new FeelingFood("소고기미니김밥",true,src_25,HOW_ROAST,true,tasty_25));


        int src_26[]={SOURCE_CHICKEN};
        int tasty_26[] = {TASTY_SWEET, TASTY_SPICY, TASTY_PALATABLE};
        foods.add(new FeelingFood("닭똥집튀김",true,src_26,HOW_FRY,true,tasty_26));


        int src_27[]={SOURCE_CHICKEN};
        int tasty_27[] = {TASTY_SWEET, TASTY_SPICY, TASTY_MIDE};
        foods.add(new FeelingFood("닭볶음밥",true,src_27,HOW_STIR_FRY,true,tasty_27));


        int src_28[]={SOURCE_PORK};
        int tasty_28[] = {TASTY_SWEET, TASTY_SPICY, TASTY_FRESH};
        foods.add(new FeelingFood("꿔바로우",true,src_28,HOW_FRY,true,tasty_28));


        int src_29[]={SOURCE_CHICKEN};
        int tasty_29[] = {TASTY_SWEET, TASTY_SPICY, TASTY_MIDE};
        foods.add(new FeelingFood("닭갈비전골",false,src_29,HOW_STIR_FRY,true,tasty_29));


        int src_30[]={SOURCE_PORK};
        int tasty_30[] = {TASTY_SWEET, TASTY_PALATABLE, TASTY_MIDE};
        foods.add(new FeelingFood("돈까스국수",true,src_30,HOW_FRY,false,tasty_30));


        int src_31[]={SOURCE_PORK};
        int tasty_31[] = {TASTY_SWEET, TASTY_MIDE};
        foods.add(new FeelingFood("큐브스테이크",true,src_31,HOW_ROAST,true,tasty_31));


        int src_32[]={SOURCE_PORK};
        int tasty_32[] = {TASTY_SWEET, TASTY_PALATABLE, TASTY_MIDE};
        foods.add(new FeelingFood("오돌뼈",true,src_32,HOW_STIR_FRY,true,tasty_32));


        int src_33[]={SOURCE_PORK};
        int tasty_33[] = {TASTY_SWEET, TASTY_PALATABLE, TASTY_MIDE};
        foods.add(new FeelingFood("육전",true,src_33,HOW_ROAST,true,tasty_33));


        int src_34[]={SOURCE_CHICKEN};
        int tasty_34[] = {TASTY_SWEET, TASTY_PALATABLE};
        foods.add(new FeelingFood("닭강정",true,src_34,HOW_FRY,true,tasty_34));


        int src_35[]={SOURCE_PORK};
        int tasty_35[] = {TASTY_SWEET, TASTY_SPICY, TASTY_PALATABLE};
        foods.add(new FeelingFood("매콤연탄불고기",false,src_35,HOW_STIR_FRY,true,tasty_35));


        int src_36[]={SOURCE_CHICKEN};
        int tasty_36[] = {TASTY_SWEET, TASTY_PALATABLE, TASTY_MIDE};
        foods.add(new FeelingFood("버팔로윙",true,src_36,HOW_FRY,true,tasty_36));


        int src_37[]={SOURCE_CHICKEN};
        int tasty_37[] = {TASTY_SWEET, TASTY_MIDE};
        foods.add(new FeelingFood("치킨까스",true,src_37,HOW_FRY,true,tasty_37));


        int src_38[]={SOURCE_PORK};
        int tasty_38[] = {TASTY_SWEET, TASTY_MIDE};
        foods.add(new FeelingFood("버터카레멘치까스",true,src_38,HOW_FRY,true,tasty_38));


        int src_39[]={SOURCE_CHICKEN};
        int tasty_39[] = {TASTY_SWEET, TASTY_SPICY, TASTY_MIDE};
        foods.add(new FeelingFood("크리스피치킨",false,src_39,HOW_FRY,true, tasty_39));

        int src_40[]={SOURCE_CHICKEN};
        int tasty_40[] = {TASTY_SWEET, TASTY_MIDE};
        foods.add(new FeelingFood("치킨롤까스",true,src_40,HOW_FRY,true,tasty_40));


        int src_41[]={SOURCE_PORK};
        int tasty_41[] = {TASTY_SWEET, TASTY_MIDE};
        foods.add(new FeelingFood("찹스테이크",true,src_41,HOW_ROAST,true,tasty_41));


        int src_42[]={SOURCE_PORK};
        int tasty_42[] = {TASTY_SPICY, TASTY_FRESH};
        foods.add(new FeelingFood("삼겹살쫄면",false,src_42,HOW_STIR_FRY,false,tasty_42));


        int src_43[]={SOURCE_PORK};
        int tasty_43[] = {TASTY_SWEET, TASTY_PALATABLE, TASTY_MIDE};
        foods.add(new FeelingFood("소불고기",true,src_43,HOW_STIR_FRY,true,tasty_43));


        int src_44[]={SOURCE_PORK};
        int tasty_44[] = {TASTY_SWEET, TASTY_MIDE};
        foods.add(new FeelingFood("제주고기국수",true,src_44,HOW_ROAST,false,tasty_44));


        int src_45[]={SOURCE_PORK};
        int tasty_45[] = {TASTY_SWEET, TASTY_MIDE};
        foods.add(new FeelingFood("불고기소바",true,src_45,HOW_ROAST,false,tasty_45));


        int src_46[]={SOURCE_PORK};
        int tasty_46[] = {TASTY_SWEET, TASTY_PALATABLE, TASTY_MIDE};
        foods.add(new FeelingFood("파불고기",true,src_46,HOW_FRY,true,tasty_46));


        int src_47[]={SOURCE_PORK};
        int tasty_47[] = {TASTY_SWEET, TASTY_MIDE};
        foods.add(new FeelingFood("불고기파스타",true,src_47,HOW_FRY,false,tasty_47));


        int src_48[]={SOURCE_CHICKEN};
        int tasty_48[] = {TASTY_SPICY, TASTY_MIDE};
        foods.add(new FeelingFood("칠리붉닭볶음면",false,src_48,HOW_STIR_FRY,false,tasty_48));


        int src_49[]={SOURCE_PORK};
        int tasty_49[] = {TASTY_SWEET, TASTY_PALATABLE, TASTY_MIDE};
        foods.add(new FeelingFood("베이컨크림파스타",true,src_49,HOW_FRY,false,tasty_49));


        int src_50[]={SOURCE_PORK};
        int tasty_50[] = {TASTY_SWEET, TASTY_PALATABLE, TASTY_MIDE};
        foods.add(new FeelingFood("돼지국수",true,src_50,HOW_FRY,false,tasty_50));

        return foods;
    }
}
