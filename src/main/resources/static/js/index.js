
var recommendMenu=[];
var orders = [];
var datas = [];

//banner
var bannerImgSrc = ["images/banner/banner1.jpg",
                    // "images/banner/banner2.jpg",
                    "images/banner/banner3.jpg",
                    "images/banner/banner4.jpg",
                    "images/banner/banner5.jpg"
];
//商品
var allGoods = [
    {
        goodId:"1",
        goodName:"卡通卫衣",
        goodDescription:"FIVE PLUS2019新款女冬装长袖连帽卫衣女宽松套头衫上衣刺绣卡通",
        goodPrice:"369.00",
        goodImgSrc:"images/goodsImg/1.jpg",
        monthSale:"100",
        commentCount:"255",
        goodIntegral:"10",
        size:["S","M","L"],
        color:["白色","黑色"],
        count:"100"
    },
    {
        goodId:"2",
        goodName:"卡通卫衣",
        goodDescription:"FIVE PLUS2019新款女冬装长袖连帽卫衣女宽松套头衫上衣刺绣卡通",
        goodPrice:"369.00",
        goodImgSrc:"images/goodsImg/2.jpg",
        monthSale:"100",
        commentCount:"255",
        goodIntegral:"10",
        size:["S","M","L"],
        color:["白色","黑色"],
        count:"100"
    },
    {
        goodId:"3",
        goodName:"卡通卫衣",
        goodDescription:"FIVE PLUS2019新款女冬装长袖连帽卫衣女宽松套头衫上衣刺绣卡通",
        goodPrice:"369.00",
        goodImgSrc:"images/goodsImg/3.jpg",
        monthSale:"100",
        commentCount:"255",
        goodIntegral:"10",
        size:["S","M","L"],
        color:["白色","黑色"],
        count:"100"
    },
    {
        goodId:"4",
        goodName:"卡通卫衣",
        goodDescription:"FIVE PLUS2019新款女冬装长袖连帽卫衣女宽松套头衫上衣刺绣卡通",
        goodPrice:"369.00",
        goodImgSrc:"images/goodsImg/4.jpg",
        monthSale:"100",
        commentCount:"255",
        goodIntegral:"10",
        size:["S","M","L"],
        color:["白色","黑色"],
        count:"100"
    },
    {
        goodId:"5",
        goodName:"卡通卫衣",
        goodDescription:"FIVE PLUS2019新款女冬装长袖连帽卫衣女宽松套头衫上衣刺绣卡通",
        goodPrice:"369.00",
        goodImgSrc:"images/goodsImg/5.jpg",
        monthSale:"100",
        commentCount:"255",
        goodIntegral:"10",
        size:["S","M","L"],
        color:["白色","黑色"],
        count:"100"
    },
    {
        goodId:"6",
        goodName:"卡通卫衣",
        goodDescription:"FIVE PLUS2019新款女冬装长袖连帽卫衣女宽松套头衫上衣刺绣卡通",
        goodPrice:"369.00",
        goodImgSrc:"images/goodsImg/6.jpg",
        monthSale:"100",
        commentCount:"255",
        goodIntegral:"10",
        size:["S","M","L"],
        color:["白色","黑色"],
        count:"100"
        },
    {
        goodId:"7",
        goodName:"卡通卫衣",
        goodDescription:"FIVE PLUS2019新款女冬装长袖连帽卫衣女宽松套头衫上衣刺绣卡通",
        goodPrice:"369.00",
        goodImgSrc:"images/goodsImg/7.jpg",
        monthSale:"100",
        commentCount:"255",
        goodIntegral:"10",
        size:["S","M","L"],
        color:["白色","黑色"],
        count:"100"
    },
    {
        goodId:"8",
        goodName:"卡通卫衣",
        goodDescription:"FIVE PLUS2019新款女冬装长袖连帽卫衣女宽松套头衫上衣刺绣卡通",
        goodPrice:"369.00",
        goodImgSrc:"images/goodsImg/8.jpg",
        monthSale:"100",
        commentCount:"255",
        goodIntegral:"10",
        size:["S","M","L"],
        color:["白色","黑色"],
        count:"100"
    },
    {
        goodId:"9",
        goodName:"卡通卫衣",
        goodDescription:"FIVE PLUS2019新款女冬装长袖连帽卫衣女宽松套头衫上衣刺绣卡通",
        goodPrice:"369.00",
        goodImgSrc:"images/goodsImg/9.jpg",
        monthSale:"100",
        commentCount:"255",
        goodIntegral:"10",
        size:["S","M","L"],
        color:["白色","黑色"],
        count:"100"
    },
    {
        goodId:"10",
        goodName:"卡通卫衣",
        goodDescription:"FIVE PLUS2019新款女冬装长袖连帽卫衣女宽松套头衫上衣刺绣卡通",
        goodPrice:"369.00",
        goodImgSrc:"images/goodsImg/10.jpg",
        monthSale:"100",
        commentCount:"255",
        goodIntegral:"10",
        size:["S","M","L"],
        color:["白色","黑色"],
        count:"100"
    },
    {
        goodId:"11",
        goodName:"卡通卫衣",
        goodDescription:"FIVE PLUS2019新款女冬装长袖连帽卫衣女宽松套头衫上衣刺绣卡通",
        goodPrice:"369.00",
        goodImgSrc:"images/goodsImg/11.jpg",
        monthSale:"100",
        commentCount:"255",
        goodIntegral:"10",
        size:["S","M","L"],
        color:["白色","黑色"],
        count:"100"
    },
    {
        goodId:"12",
        goodName:"卡通卫衣",
        goodDescription:"FIVE PLUS2019新款女冬装长袖连帽卫衣女宽松套头衫上衣刺绣卡通",
        goodPrice:"369.00",
        goodImgSrc:"images/goodsImg/12.jpg",
        monthSale:"100",
        commentCount:"255",
        goodIntegral:"10",
        size:["S","M","L"],
        color:["白色","黑色"],
        count:"100"
        },
];
var currentUser = {
    "userName":"小沐童",
    "headImg":"images/headImg/headImg1.jpg"
};
//动态获取轮播图的高度
window.onload=function()
{
    // var bannerH = $('.banner-div img')[0].height;
    var bannerH = 400;
    $('.layui-carousel').css('height',bannerH+'px');
};
//===== layui =====
var $,layer;
// layer = layui.layer;
layui.use("layer",function() {
    $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句

});
//====== 图片轮播 =====
layui.use('carousel', function(){
    var carousel = layui.carousel;
    //建造实例
     carousel.render({
     elem: '#banner-carousel'
   ,width: '100%' //设置容器宽度
   ,arrow: 'always' //始终显示箭头
   //,anim: 'updown' //切换动画方式
     });
});

function showCart() {
    $(".cart").slideToggle(400);
}

var app = angular.module("PaySystem", ["ngRoute"]);
/*-----------------主页----------------------*/
app.controller("homeControl",["$scope",function($scope){
    $scope.bannerImgSrc = bannerImgSrc;
    $scope.test="hello";
}]);
app.controller("indexControl", ["$scope", "$rootScope", "$http", function ($scope, $rootScope, $http) {
    $rootScope.isSignUp = false;
    $rootScope.currentUser = currentUser;

    //用户点击登录
    $scope.showSignInDialog = function()
    {
        var that = this;
       layer.open({
                      type: 1
                      ,maxWidth:450
                      ,title: "用户登录" //不显示标题栏
                      ,area: '450px;'
                      ,shade: 0.8
                      ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
                      ,btnAlign: 'c'
                      ,moveType: 1 //拖拽模式，0或者1
                      ,content: $("#signInDialog")
                      ,btn: ['登　录']
                      ,btn1:function(){
                           if($scope.userName=="w_juan" && $scope.userPass=="07081024")
                           {
                               $scope.isSignUp = true;
                               console.log($scope.isSignUp);
                               // layer.closeAll();
                               $scope.$apply();
                               layer.close(layer.index);
                           }
                           else
                           {
                               layer.alert('用户名或密码输入错误！', {icon: 5,closeBtn:false});
                           }
                      }
           });

    };

    //用户点击注册
    $scope.showSignUpDialog=function()
    {
        $scope.signUpInfoCorrect = false;
        $scope.signUpCorrect = false;
        layui.use('form', function(){
            var form = layui.form;
            form.render();
        });
        layer.open({
                   type: 1
                   ,maxWidth:450
                   ,title: "用户注册" //不显示标题栏
                   ,area: '450px;'
                   ,shade: 0.8
                   ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
                   ,btnAlign: 'c'
                   ,moveType: 1 //拖拽模式，0或者1
                   ,content: $("#signUpDialog")
                   ,btn: ['注　册']
                   ,btn1:function(){
                    var emailReg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
                    var telReg = /^[1][3,4,5,7,8][0-9]{9}$/;
                    console.log("userName:"+$scope.signUpUserName);
                    //判断用户名
                    if($scope.signUpUserName == "")
                    {
                        layer.alert('给自己取个名字吧！', {icon: 5,closeBtn:false});
                        $scope.signUpInfoCorrect = false;
                    }
                    else{
                        //判断邮箱和电话
                        if(emailReg.test($scope.signUpuserCount) || telReg.test($scope.signUpUserCount))
                            {
                                if($scope.userPass == "")
                                {
                                    layer.alert('请输入密码！', {icon: 5,closeBtn:false});
                                    $scope.signUpInfoCorrect = false;
                                }
                                else {
                                    //两次密码输入不一致
                                    if($scope.signUpUserPass != $scope.signUpUserConfirmPass)
                                    {
                                        $scope.signUpInfoCorrect = false;
                                       layer.alert('两次密码输入不一致！', {icon: 5,closeBtn:false});
                                    }
                                    else{
                                        $scope.signUpInfoCorrect = true;
                                    }
                                }
                            }
                        else
                            {
                            layer.alert('请输入正确的邮箱或手机号码！', {icon: 5,closeBtn:false});
                            $scope.signUpInfoCorrect = false;
                        }
                    }
                    //用户输入信息均合法
                    if($scope.signUpInfoCorrect)
                    {
                        $scope.currentUser={
                            userName:$scope.signUpUserName,
                            userCount:$scope.signUpUserCount,
                            userPass:$scope.signUpUserPass,
                            userSex:$("input[type=radio]:checked").val()
                        };
                        console.log($scope.currentUser);
                        $scope.signUpCorrect = true;
                        layer.close(layer.index);
                    }
                   }
                });
        console.log("hhh12,注册正确："+$scope.signUpCorrect);
        if($scope.signUpCorrect)
        {
            console.log("hhh");
            signInDialog();
        }
    };
    $scope.signIn=function()
    {
        console.log("hello");


    };
    //$rootScope.orders=[];
    $rootScope.bannerImgSrc=bannerImgSrc;
    $scope.allGoods = allGoods;
    //筛选对应分类菜单
    $rootScope.filterClass=function(dataClass){
        angular.forEach(dataClass,function(item){
            angular.forEach($rootScope.orders,function(order){
                if(order.length!=0){
                    if(item.id==order.id){
                        item.selected=true;
                    }
                }else{
                    item.selected=false;
                    return dataClass;
                }
            })
        });
        return dataClass;
    };
    //显示菜品详情
    $rootScope.showDetail = function (food) {
        $rootScope.food = food;
    };
    /*
    //获取菜单
    $http({
        method: "Get",
        url: "../data/data.json"
    }).then(function successCallback(response) {
        $scope.defaultHot = response.data.recommend[2];
        for (var i = 1; i < response.data.recommend.length; i++) {
            recommendMenu.push(response.data.recommend[i]);
        }
        datas = response.data;
        $scope.hotMenu =datas.hot;  //热门菜品
        $scope.allRecommend = datas.recommend;
        $rootScope.filterClass($scope.hotMenu);
        $rootScope.filterClass($scope.allRecommend);
    });

     */
    //$scope.recommend = recommendMenu; //推荐菜品,除第一个
    $rootScope.orders = orders;   //已点菜单
    $rootScope.order = function (x) {
        x.selected = true;
        x.num += 1;
        orders.push(x);
    };
}]);

app.controller("goodDetailControl",["$scope",function($scope){
    $scope.currentGood = allGoods[0];
}]);

/*------订单-------*/
app.controller("orderCtr", ["$scope", "$rootScope","$location", function ($scope, $rootScope,$location) {
    //获取数据
    $scope.text=$rootScope.orders;
    //获取到点击函数对应的所有input
    //var a=document.getElementsByClassName("width30");
    //获取到作用域的数据
    var datas=$scope.text;
    console.log(datas.length);
    //点击增加数量函数
    $scope.add = function(index){
        var num=Number($scope.text[index].num)+1;
        $scope.text[index].num=num;
        //调用已选菜品数量函数
        total();
        //调用计算总价函数
        cost();
        subTotals();
    };
    //点击减少数量函数
    $scope.reduce = function(index){
        var num=Number($scope.text[index].num)-1;
        if(num<1){
            num=1;
        };
        $scope.text[index].num=num;
        //调用已选菜品数量函数
        total();
        //调用计算总价函数
        cost();
        subTotals();
    };

    //页面加载时，就自调用该函数一次
    total();
    cost();

    //删除函数
    $scope.delete = function(index){
        $scope.text.splice(index,1);
        //调用已选菜品数量函数
        total();
        //调用计算总价函数
        cost();
    };

    //小计函数
    function subTotals(){
        var a;
        var subtotal=document.getElementsByClassName("subtotal");
        for(var i=0;i<datas.length;i++){
            a=Number(datas[i].num)*Number(datas[i].price);
            subtotal[i].innerHTML=a+"元";
        };
    };
    //计算总价函数
    function cost(){
        var a=0;
        for(var i=0;i<datas.length;i++){
            a=a+Number(datas[i].num)*Number(datas[i].price);
        };
        var cost=document.getElementById("cost");
        cost.innerHTML=a;
    };

    //获取已点菜品数量函数
    function total(){
        var a=0;
        for(var i=0;i<datas.length;i++){
            a=a+Number(datas[i].num);
        };
        var total=document.getElementById("total");
        total.innerHTML=a;
    };

    //页面渲染完毕，调用函数
    $scope.$on("ngRepeatFinished",function(ngRepeatFinishedEvent){
        //页面渲染完毕后立即加载显示小计价格函数
        function subTotal(){
            var a;
            var subtotal=document.getElementsByClassName("subtotal");
            for(var i=0;i<datas.length;i++){
                a=Number(datas[i].num)*Number(datas[i].price);
                subtotal[i].innerHTML=a+"元";
            };
        };
        subTotal();
    });
    //提交函数
    $scope.submit=function (){
        setTimeout(function(){
           /* $location.path('/main');
            $scope.text.length=0;
            $rootScope.orders=[];*/
            window.location="test.html";
        },3000)
    };
}]);

/*-------餐厅介绍--------*/
app.controller("introCtr",["$scope","$rootScope",function($scope,$rootScope){

}]);

//配置路由
app.config(["$routeProvider", function ($routeProvider) {
    $routeProvider.when("/home", {   //主页
        controller: "homeControl",
        templateUrl: "route/home.html"
    }).when("/signIn", {
        controller: "signInControl",
        templateUrl: "route/signIn.html"
    }).when("/signUp", {
        controller: "signUpControl",
        templateUrl: "route/signUp.html"
    }).when("/goodDetail",{
        controller:"goodDetailControl",
        templateUrl:"route/goodDetail.html"
    }).otherwise({redirectTo: "/home"});
}]);

//分类页数据分配
app.controller("homeControl", ["$scope", "$rootScope", function ($scope, $rootScope) {
    $scope.datas = datas.main;
    $rootScope.filterClass($scope.datas);
}]);
app.controller("signInControl", ["$scope", "$rootScope", function ($scope, $rootScope) {
    $scope.datas = datas.soup;
    $rootScope.filterClass($scope.datas);
}]);
app.controller("signUpControl", ["$scope", "$rootScope", function ($scope, $rootScope) {
    $scope.datas = datas.wine;
    $rootScope.filterClass($scope.datas);
}]);



/*-----------自定义指令-------------*/
//自定义指令，菜品信息详情
app.directive("detail", function () {
    return {
        restrict: "AE",
        templateUrl: "detail.html",
        scope: false
    }
});
//自定义指令在渲染页面完毕后可以执行js脚本
app.directive("onFinishRenderFilters",function($timeout){
    return{
        restrict:'A',
        link:function(scope,element,attr){
            if(scope.$last === true){
                $timeout(function(){
                    scope.$emit("ngRepeatFinished")
                });
            }
        }
    }
});
