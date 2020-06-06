package com.hnrmb.Page;

import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.UiObjectNew;

class AllMoneyDetail {

    public Solo solo;
    public UiObjectNew UN;
    public AllMoneyDetail(Solo so) {
        solo = so;
        UN = UiObjectNew.getInstance(so);
    }

    private final String all = "com.hnrmb.salary:id/tv_asset_value"; // 总资产
    private final String part1 = "com.hnrmb.salary:id/first_content_tv"; // 资产组成第一份
    private final String part2 = "com.hnrmb.salary:id/second_content_tv"; // 资产组成第二份
    private final String part3 = "com.hnrmb.salary:id/third_content_tv"; // 资产组成第三份
    private final String part4 = "com.hnrmb.salary:id/fourth_content_tv"; // 资产组成第四份

}
