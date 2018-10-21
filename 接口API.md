域名：www.guohanghuang.cn:8443

**url：/login**

**参数：code,nickName,avatarUrl**

**返回：openId，phone**

错误信息：

1.code为空或错误，返回400

2.服务器连接微信后台失败，返回504

 

获取短信：

**url：/getSms**

**参数：phone**

返回：4位数字

错误信息：500，后台出错，请重试

 

设置用户手机号

**url：/setPhone**

**参数：openId，phone**

返回：手机号码

错误信息：返回400，参数错误

 

 

 

 

获取所有商品：

**url:/goods**     

**参数：openId**

返回：

1.      如果是vip用户：

[

​    {

​        "priceId": 1,                 //商品id

​        "name": "test",      //商品名

​        "detail": "detail",   //商品详情

​        "pictures": [           //商品轮播图片

​            "test.img"

​        ],

​        "priceList": [     //商品价格列表

​            {

​                "priceId": 1,                  //价格id

​                "price": 4665,        //价格，单位为分，前端需除以100换成元显示

​                "num": 100,          //库存

​                "models": [      //商品型号

​                    {

​                        "smallModelName": "180",  //小型号

​                        "bigModelName": "尺寸"    //大型号

​                    },

​                    {

​                        "smallModelName": "蓝色",    //小型号

 

​                        "bigModelName": "颜色"   //大型号

 

​                    }

​                ]

​            },

​            {

​                "id": 2,

​                "price": 5500,

​                "num": 100,

​                "models": [

​                    {

​                        "smallModelName": "绿色",

​                        "bigModelName": "颜色"

​                    }

​                ]

​            }

​        ],

​        "integral": 1,   //卖出一件商品可得的vip积分

​        "batch": 100,    //商品起批量

​        "allRetail": 0,     //商品总零售量

​        "monthRetail": 0   //商品本月零售量

​    }

]

 

2.      如果是普通用户：

[

​    {

​        "priceId": 1,                 //商品id

​        "name": "test",      //商品名

​        "detail": "detail",   //商品详情

​        "pictures": [           //商品轮播图片

​            "test.img"

​        ],

​        "priceList": [     //商品价格列表

​            {

​                "priceId": 1,                  //价格id

​                "price": 4665,        //价格，单位为分，前端需除以100换成元显示

​                "num": 100,          //库存

​                "models": [      //商品型号

​                    {

​                        "smallModelName": "180",  //小型号

​                        "bigModelName": "尺寸"    //大型号

​                    },

​                    {

​                        "smallModelName": "蓝色",    //小型号

 

​                        "bigModelName": "颜色"   //大型号

 

​                    }

​                ]

​            },

​            {

​                "id": 2,

​                "price": 5500,

​                "num": 100,

​                "models": [

​                    {

​                        "smallModelName": "绿色",

​                        "bigModelName": "颜色"

​                    }

​                ]

​            }

​        ],

​    }

]

 

 

获取单个收货地址：

**url:/address/singleAddress**

**参数：addressId**



获取默认地址：
 **url：/getDefaultAddress**

**参数：openId**

 

 

获取用户所有收货地址：

**url:/address**

**参数：openId**

返回：

[

​    {

​        "openId": null,  

​        "id": 4, //收货地址id

​        "name": "hgh", //收货人

​        "address": "北京路",  //收货地址

​        "phone": "13724125552", //收货人手机号

​        "state": 0  //是否为默认收获地址，1为默认，0为非默认

​    },

​    {

​        "openId": null,

​        " id ": 7,

​        "name": "123",

​        "address": "1231",

​        "phone": "12313",

​        "state": 1

​    }

]

 

添加收货地址：

**url:/addAddress**

参数：

{

​        "openId": "test",   //openId

​        "name": "123",      //收货人姓名

“detailAddress”：“1231”//门牌号

​        "address": "12312311",  //收货地址

​        "phone": "12313121",   //收货人电话   

}

错误信息：400参数错误，500，后台出错

 

修改收获地址：

**url:/updateAddress**

参数：

{

​        "id": 1,   //收货地址id

​        "name": "123",      //收货人姓名

​        "address": "12312311",  //收货地址

​        "phone": "12313121",   //收货人电话   

}

错误信息：400参数错误，500，后台出错

 

设置默认收货地址：

**url: /upadteStateForAddress**

**参数：openId, addressId**

错误信息：400参数错误，500，后台出错

 

 

删除收货地址：

**url:/ deleteAddress**

**参数：addressId**

错误信息：400参数错误，500，后台出错

 

 

获取单个商品：

**url:goods/singleGoods**

**参数：goodsId**

返回：

{

​    "goodsId": 1,

​    "name": "test",

​    "detail": "detail",

​    "pictures": [

​        "123",

​        "321"

​    ],

​    "priceList": [

​        {

​            "priceId": 1,

​            "price": 4665,

​            "num": 100,

​            "models": [

​                {

​                    "smallModelName": "180",

​                    "bigModelName": "尺寸"

​                },

​                {

​                    "smallModelName": "蓝色",

​                    "bigModelName": "颜色"

​                }

​            ]

​        },

​        {

​            "priceId": 2,

​            "price": 5500,

​            "num": 100,

​            "models": [

​                {

​                    "smallModelName": "绿色",

​                    "bigModelName": "颜色"

​                }

​            ]

​        }

​    ]

}

 

 

获取商品的评论:

**url:/ comments**

**参数：goodsId**

返回：

[

​    {

​        "userInfo": {

​            "nickName": "hgh123", //用户昵称

​            "avatarUrl": "mytest.img"  //用户头像

​        },

​        "content": "test", //评论的内容

​        "star": 5,      //评论星数

​        "createTime": "2018-10-17",  //评论时间

​        "modelNames": [      //购买商品的类型

​            "蓝色"，

​                     “180”，

​                     “秋季下装”

​        ]

​    }

]

 

 

获取购物车：

**url：/shoppingcar**

**参数：openId**

返回：

[

​    {

​        "shoppingcarId": 2,   //购物车的行id

​        "shoppingcarGoods": {   //购物车这一行的商品

​            "goodsId": 1,       //

​            "goodsName": "test",  //商品名

​            "goodsPicture": "123" //商品图片

​        },

​        "price": 5500,  //价格

​        "priceModels": [   //商品的类型

​            "绿色"，

​                     “180”，

​                     “下装”

​        ],

​        "buyNum": 21,  //购买数量

​        "state": 0   //是否选中，1为选中

​    }

]

 

删除购物车里某一行的商品：

**url：/deleteShoppingcar**

**参数：shoppingcarId**

返回：成功返回状态码200，true；失败返回状态码400，false

 

修改购物车里商品购买数量：

**url：/updateBuyNumForShoppingcar**

**参数：buyNum，shoppingcarId**

返回：成功返回状态码200，true；失败返回状态码400，false

 

修改购物车的商品是否选中：

**url:/updateStateForShoppingcar**
**参数：state, shoppingcarId**

返回：成功返回状态码200，true；失败返回状态码400，false