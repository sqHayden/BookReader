package com.idx.reader.subscribe;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by steve on 17-9-14.
 * 创建数据库及表
 */

public class MyDatabaseHandler extends SQLiteOpenHelper {

    public MyDatabaseHandler(Context context) {
        super(context, "mdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="create table subscribe(id integer primary key autoincrement,imageId integer,title,desc,comment,type,time)";
        sqLiteDatabase.execSQL(sql);
        //one
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(0,'习近平向第二届中国质量（上海）大会致贺信'," +
                "'新华社上海9月15日电第二届中国质量（上海）大会15日在上海开幕，国家主席习近平致贺信，对会议的召开表示热烈祝贺。'," +
                "'200','1','今天 15:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(1,'帕米尔牧羊人的最后一个游牧之夏'," +
                "'南疆四地州是国家确定的14个集中连片特困地区之一，贫困程度深，而帕米尔高原则是南疆脱贫攻坚中最难啃的 硬骨头 。这里海拔高、条件艰苦、自然环境恶劣、自然灾害频发，基础设施建设推进难度极大。因此，易地扶贫搬迁，成了改变帕米尔高原牧民生活的可行路径。'," +
                "'100', '2', '昨天 09:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(2,'住房租赁市场政策不断加码 各地排兵布阵调控忙'," +
                "'随着住房租赁市场相关政策不断加码，各地纷纷瞄准这块市场进行排兵布阵，并且在较短时间内取得了可喜进展。'," +
                "'400', '0', '16:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(3,'公办园试点 半日班 惹争议 幼儿园 入园难 如何解'," +
                "'去年起，北京市东西城部分幼儿园在小班试点 半日班 ，今年，两区尝试这种模式的公办幼儿园至少有十余家。'," +
                "'0', '1', '09月16日 15:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(4,'一张张笑脸见证命运转折——西北各族群众生活图景扫描'," +
                "'新华社兰州9月15日电题：一张张笑脸见证命运转折——西北各族群众生活图景扫描新华社记者张钦1935年至1936年，青年记者范长江 因为时代的苦闷 行走西北角，一路所见，大多是 房屋日益破坏，生活日益艰难 。'," +
                "'500', '0', '01月16日 08:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(5,'一个中部地级市的 人才回流 实验'," +
                "'在大众创业、万众创新的滚滚热潮中,在外打拼的抚州才子返乡创新的步伐,迈得越来越快。不断缩短的返乡时间,正是近年来抚州大搞 人才回流 的一个注脚。'," +
                "'700', '2', '17:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(6,'环保部:成立专家团队指导京津冀及周边 2+26 城市'," +
                "'大气重污染成因与治理攻关领导小组组长、环境保护部部长李干杰14日主持召开大气重污染成因与治理攻关领导小组第二次会议暨攻关项目启动大会。'," +
                "'10', '0', '01:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(7,'台风橙色预警：受 杜苏芮 影响 海南风力达10-12级'," +
                "'今年第19号台风 杜苏芮 已于今天（15日）凌晨加强为强台风级，早晨5点钟其中心位于越南北部海岸约180公里的南海中西部海面上。'," +
                "'30', '1', '刚刚')");

        //two
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(0,'习近平向第二届中国质量（上海）大会致贺信'," +
                "'新华社上海9月15日电第二届中国质量（上海）大会15日在上海开幕，国家主席习近平致贺信，对会议的召开表示热烈祝贺。'," +
                "'200','1','今天 15:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(1,'帕米尔牧羊人的最后一个游牧之夏'," +
                "'南疆四地州是国家确定的14个集中连片特困地区之一，贫困程度深，而帕米尔高原则是南疆脱贫攻坚中最难啃的 硬骨头 。这里海拔高、条件艰苦、自然环境恶劣、自然灾害频发，基础设施建设推进难度极大。因此，易地扶贫搬迁，成了改变帕米尔高原牧民生活的可行路径。'," +
                "'100', '2', '昨天 09:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(2,'住房租赁市场政策不断加码 各地排兵布阵调控忙'," +
                "'随着住房租赁市场相关政策不断加码，各地纷纷瞄准这块市场进行排兵布阵，并且在较短时间内取得了可喜进展。'," +
                "'400', '0', '16:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(3,'公办园试点 半日班 惹争议 幼儿园 入园难 如何解'," +
                "'去年起，北京市东西城部分幼儿园在小班试点 半日班 ，今年，两区尝试这种模式的公办幼儿园至少有十余家。'," +
                "'0', '1', '09月16日 15:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(4,'一张张笑脸见证命运转折——西北各族群众生活图景扫描'," +
                "'新华社兰州9月15日电题：一张张笑脸见证命运转折——西北各族群众生活图景扫描新华社记者张钦1935年至1936年，青年记者范长江 因为时代的苦闷 行走西北角，一路所见，大多是 房屋日益破坏，生活日益艰难 。'," +
                "'500', '0', '01月16日 08:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(5,'一个中部地级市的 人才回流 实验'," +
                "'在大众创业、万众创新的滚滚热潮中,在外打拼的抚州才子返乡创新的步伐,迈得越来越快。不断缩短的返乡时间,正是近年来抚州大搞 人才回流 的一个注脚。'," +
                "'700', '2', '17:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(6,'环保部:成立专家团队指导京津冀及周边 2+26 城市'," +
                "'大气重污染成因与治理攻关领导小组组长、环境保护部部长李干杰14日主持召开大气重污染成因与治理攻关领导小组第二次会议暨攻关项目启动大会。'," +
                "'10', '0', '01:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(7,'台风橙色预警：受 杜苏芮 影响 海南风力达10-12级'," +
                "'今年第19号台风 杜苏芮 已于今天（15日）凌晨加强为强台风级，早晨5点钟其中心位于越南北部海岸约180公里的南海中西部海面上。'," +
                "'30', '1', '刚刚')");

        //three
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(0,'习近平向第二届中国质量（上海）大会致贺信'," +
                "'新华社上海9月15日电第二届中国质量（上海）大会15日在上海开幕，国家主席习近平致贺信，对会议的召开表示热烈祝贺。'," +
                "'200','1','今天 15:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(1,'帕米尔牧羊人的最后一个游牧之夏'," +
                "'南疆四地州是国家确定的14个集中连片特困地区之一，贫困程度深，而帕米尔高原则是南疆脱贫攻坚中最难啃的 硬骨头 。这里海拔高、条件艰苦、自然环境恶劣、自然灾害频发，基础设施建设推进难度极大。因此，易地扶贫搬迁，成了改变帕米尔高原牧民生活的可行路径。'," +
                "'100', '2', '昨天 09:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(2,'住房租赁市场政策不断加码 各地排兵布阵调控忙'," +
                "'随着住房租赁市场相关政策不断加码，各地纷纷瞄准这块市场进行排兵布阵，并且在较短时间内取得了可喜进展。'," +
                "'400', '0', '16:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(3,'公办园试点 半日班 惹争议 幼儿园 入园难 如何解'," +
                "'去年起，北京市东西城部分幼儿园在小班试点 半日班 ，今年，两区尝试这种模式的公办幼儿园至少有十余家。'," +
                "'0', '1', '09月16日 15:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(4,'一张张笑脸见证命运转折——西北各族群众生活图景扫描'," +
                "'新华社兰州9月15日电题：一张张笑脸见证命运转折——西北各族群众生活图景扫描新华社记者张钦1935年至1936年，青年记者范长江 因为时代的苦闷 行走西北角，一路所见，大多是 房屋日益破坏，生活日益艰难 。'," +
                "'500', '0', '01月16日 08:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(5,'一个中部地级市的 人才回流 实验'," +
                "'在大众创业、万众创新的滚滚热潮中,在外打拼的抚州才子返乡创新的步伐,迈得越来越快。不断缩短的返乡时间,正是近年来抚州大搞 人才回流 的一个注脚。'," +
                "'700', '2', '17:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(6,'环保部:成立专家团队指导京津冀及周边 2+26 城市'," +
                "'大气重污染成因与治理攻关领导小组组长、环境保护部部长李干杰14日主持召开大气重污染成因与治理攻关领导小组第二次会议暨攻关项目启动大会。'," +
                "'10', '0', '01:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(7,'台风橙色预警：受 杜苏芮 影响 海南风力达10-12级'," +
                "'今年第19号台风 杜苏芮 已于今天（15日）凌晨加强为强台风级，早晨5点钟其中心位于越南北部海岸约180公里的南海中西部海面上。'," +
                "'30', '1', '刚刚')");

        //four
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(0,'习近平向第二届中国质量（上海）大会致贺信'," +
                "'新华社上海9月15日电第二届中国质量（上海）大会15日在上海开幕，国家主席习近平致贺信，对会议的召开表示热烈祝贺。'," +
                "'200','1','今天 15:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(1,'帕米尔牧羊人的最后一个游牧之夏'," +
                "'南疆四地州是国家确定的14个集中连片特困地区之一，贫困程度深，而帕米尔高原则是南疆脱贫攻坚中最难啃的 硬骨头 。这里海拔高、条件艰苦、自然环境恶劣、自然灾害频发，基础设施建设推进难度极大。因此，易地扶贫搬迁，成了改变帕米尔高原牧民生活的可行路径。'," +
                "'100', '2', '昨天 09:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(2,'住房租赁市场政策不断加码 各地排兵布阵调控忙'," +
                "'随着住房租赁市场相关政策不断加码，各地纷纷瞄准这块市场进行排兵布阵，并且在较短时间内取得了可喜进展。'," +
                "'400', '0', '16:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(3,'公办园试点 半日班 惹争议 幼儿园 入园难 如何解'," +
                "'去年起，北京市东西城部分幼儿园在小班试点 半日班 ，今年，两区尝试这种模式的公办幼儿园至少有十余家。'," +
                "'0', '1', '09月16日 15:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(4,'一张张笑脸见证命运转折——西北各族群众生活图景扫描'," +
                "'新华社兰州9月15日电题：一张张笑脸见证命运转折——西北各族群众生活图景扫描新华社记者张钦1935年至1936年，青年记者范长江 因为时代的苦闷 行走西北角，一路所见，大多是 房屋日益破坏，生活日益艰难 。'," +
                "'500', '0', '01月16日 08:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(5,'一个中部地级市的 人才回流 实验'," +
                "'在大众创业、万众创新的滚滚热潮中,在外打拼的抚州才子返乡创新的步伐,迈得越来越快。不断缩短的返乡时间,正是近年来抚州大搞 人才回流 的一个注脚。'," +
                "'700', '2', '17:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(6,'环保部:成立专家团队指导京津冀及周边 2+26 城市'," +
                "'大气重污染成因与治理攻关领导小组组长、环境保护部部长李干杰14日主持召开大气重污染成因与治理攻关领导小组第二次会议暨攻关项目启动大会。'," +
                "'10', '0', '01:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(7,'台风橙色预警：受 杜苏芮 影响 海南风力达10-12级'," +
                "'今年第19号台风 杜苏芮 已于今天（15日）凌晨加强为强台风级，早晨5点钟其中心位于越南北部海岸约180公里的南海中西部海面上。'," +
                "'30', '1', '刚刚')");

        //five
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(0,'习近平向第二届中国质量（上海）大会致贺信'," +
                "'新华社上海9月15日电第二届中国质量（上海）大会15日在上海开幕，国家主席习近平致贺信，对会议的召开表示热烈祝贺。'," +
                "'200','1','今天 15:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(1,'帕米尔牧羊人的最后一个游牧之夏'," +
                "'南疆四地州是国家确定的14个集中连片特困地区之一，贫困程度深，而帕米尔高原则是南疆脱贫攻坚中最难啃的 硬骨头 。这里海拔高、条件艰苦、自然环境恶劣、自然灾害频发，基础设施建设推进难度极大。因此，易地扶贫搬迁，成了改变帕米尔高原牧民生活的可行路径。'," +
                "'100', '2', '昨天 09:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(2,'住房租赁市场政策不断加码 各地排兵布阵调控忙'," +
                "'随着住房租赁市场相关政策不断加码，各地纷纷瞄准这块市场进行排兵布阵，并且在较短时间内取得了可喜进展。'," +
                "'400', '0', '16:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(3,'公办园试点 半日班 惹争议 幼儿园 入园难 如何解'," +
                "'去年起，北京市东西城部分幼儿园在小班试点 半日班 ，今年，两区尝试这种模式的公办幼儿园至少有十余家。'," +
                "'0', '1', '09月16日 15:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(4,'一张张笑脸见证命运转折——西北各族群众生活图景扫描'," +
                "'新华社兰州9月15日电题：一张张笑脸见证命运转折——西北各族群众生活图景扫描新华社记者张钦1935年至1936年，青年记者范长江 因为时代的苦闷 行走西北角，一路所见，大多是 房屋日益破坏，生活日益艰难 。'," +
                "'500', '0', '01月16日 08:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(5,'一个中部地级市的 人才回流 实验'," +
                "'在大众创业、万众创新的滚滚热潮中,在外打拼的抚州才子返乡创新的步伐,迈得越来越快。不断缩短的返乡时间,正是近年来抚州大搞 人才回流 的一个注脚。'," +
                "'700', '2', '17:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(6,'环保部:成立专家团队指导京津冀及周边 2+26 城市'," +
                "'大气重污染成因与治理攻关领导小组组长、环境保护部部长李干杰14日主持召开大气重污染成因与治理攻关领导小组第二次会议暨攻关项目启动大会。'," +
                "'10', '0', '01:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(7,'台风橙色预警：受 杜苏芮 影响 海南风力达10-12级'," +
                "'今年第19号台风 杜苏芮 已于今天（15日）凌晨加强为强台风级，早晨5点钟其中心位于越南北部海岸约180公里的南海中西部海面上。'," +
                "'30', '1', '刚刚')");

        //six
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(0,'习近平向第二届中国质量（上海）大会致贺信'," +
                "'新华社上海9月15日电第二届中国质量（上海）大会15日在上海开幕，国家主席习近平致贺信，对会议的召开表示热烈祝贺。'," +
                "'200','1','今天 15:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(1,'帕米尔牧羊人的最后一个游牧之夏'," +
                "'南疆四地州是国家确定的14个集中连片特困地区之一，贫困程度深，而帕米尔高原则是南疆脱贫攻坚中最难啃的 硬骨头 。这里海拔高、条件艰苦、自然环境恶劣、自然灾害频发，基础设施建设推进难度极大。因此，易地扶贫搬迁，成了改变帕米尔高原牧民生活的可行路径。'," +
                "'100', '2', '昨天 09:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(2,'住房租赁市场政策不断加码 各地排兵布阵调控忙'," +
                "'随着住房租赁市场相关政策不断加码，各地纷纷瞄准这块市场进行排兵布阵，并且在较短时间内取得了可喜进展。'," +
                "'400', '0', '16:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(3,'公办园试点 半日班 惹争议 幼儿园 入园难 如何解'," +
                "'去年起，北京市东西城部分幼儿园在小班试点 半日班 ，今年，两区尝试这种模式的公办幼儿园至少有十余家。'," +
                "'0', '1', '09月16日 15:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(4,'一张张笑脸见证命运转折——西北各族群众生活图景扫描'," +
                "'新华社兰州9月15日电题：一张张笑脸见证命运转折——西北各族群众生活图景扫描新华社记者张钦1935年至1936年，青年记者范长江 因为时代的苦闷 行走西北角，一路所见，大多是 房屋日益破坏，生活日益艰难 。'," +
                "'500', '0', '01月16日 08:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(5,'一个中部地级市的 人才回流 实验'," +
                "'在大众创业、万众创新的滚滚热潮中,在外打拼的抚州才子返乡创新的步伐,迈得越来越快。不断缩短的返乡时间,正是近年来抚州大搞 人才回流 的一个注脚。'," +
                "'700', '2', '17:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(6,'环保部:成立专家团队指导京津冀及周边 2+26 城市'," +
                "'大气重污染成因与治理攻关领导小组组长、环境保护部部长李干杰14日主持召开大气重污染成因与治理攻关领导小组第二次会议暨攻关项目启动大会。'," +
                "'10', '0', '01:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(7,'台风橙色预警：受 杜苏芮 影响 海南风力达10-12级'," +
                "'今年第19号台风 杜苏芮 已于今天（15日）凌晨加强为强台风级，早晨5点钟其中心位于越南北部海岸约180公里的南海中西部海面上。'," +
                "'30', '1', '刚刚')");

        //seven
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(0,'习近平向第二届中国质量（上海）大会致贺信'," +
                "'新华社上海9月15日电第二届中国质量（上海）大会15日在上海开幕，国家主席习近平致贺信，对会议的召开表示热烈祝贺。'," +
                "'200','1','今天 15:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(1,'帕米尔牧羊人的最后一个游牧之夏'," +
                "'南疆四地州是国家确定的14个集中连片特困地区之一，贫困程度深，而帕米尔高原则是南疆脱贫攻坚中最难啃的 硬骨头 。这里海拔高、条件艰苦、自然环境恶劣、自然灾害频发，基础设施建设推进难度极大。因此，易地扶贫搬迁，成了改变帕米尔高原牧民生活的可行路径。'," +
                "'100', '2', '昨天 09:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(2,'住房租赁市场政策不断加码 各地排兵布阵调控忙'," +
                "'随着住房租赁市场相关政策不断加码，各地纷纷瞄准这块市场进行排兵布阵，并且在较短时间内取得了可喜进展。'," +
                "'400', '0', '16:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(3,'公办园试点 半日班 惹争议 幼儿园 入园难 如何解'," +
                "'去年起，北京市东西城部分幼儿园在小班试点 半日班 ，今年，两区尝试这种模式的公办幼儿园至少有十余家。'," +
                "'0', '1', '09月16日 15:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(4,'一张张笑脸见证命运转折——西北各族群众生活图景扫描'," +
                "'新华社兰州9月15日电题：一张张笑脸见证命运转折——西北各族群众生活图景扫描新华社记者张钦1935年至1936年，青年记者范长江 因为时代的苦闷 行走西北角，一路所见，大多是 房屋日益破坏，生活日益艰难 。'," +
                "'500', '0', '01月16日 08:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(5,'一个中部地级市的 人才回流 实验'," +
                "'在大众创业、万众创新的滚滚热潮中,在外打拼的抚州才子返乡创新的步伐,迈得越来越快。不断缩短的返乡时间,正是近年来抚州大搞 人才回流 的一个注脚。'," +
                "'700', '2', '17:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(6,'环保部:成立专家团队指导京津冀及周边 2+26 城市'," +
                "'大气重污染成因与治理攻关领导小组组长、环境保护部部长李干杰14日主持召开大气重污染成因与治理攻关领导小组第二次会议暨攻关项目启动大会。'," +
                "'10', '0', '01:30')");
        sqLiteDatabase.execSQL("insert into subscribe(imageId,title,desc,comment,type,time) " +
                "values(7,'台风橙色预警：受 杜苏芮 影响 海南风力达10-12级'," +
                "'今年第19号台风 杜苏芮 已于今天（15日）凌晨加强为强台风级，早晨5点钟其中心位于越南北部海岸约180公里的南海中西部海面上。'," +
                "'30', '1', '刚刚')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
         System.out.print("---onUpgrade() called:"+i+"--->"+i1);
    }
}
