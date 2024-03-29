package com.example.dmall.controller;

import com.example.dmall.bean.*;
import com.example.dmall.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/findAllProduct")
    public List<Product> findAll()
    {
        List<Product> list=productService.listAllProduct();
        System.out.println("程序一直执行这个程序");
        return list;
    }

    @GetMapping("/findProductsByCategory/{category_id}")
    public Msg findProductsByCategory(@PathVariable(value = "category_id") Integer category_id)
    {
        System.out.println(" 打印产品id"+category_id);

        //第一步查出产品的信息
        List<Product> products=productService.findProductsByCategory(category_id);
        //第二步，遍历产品信息集合
        for(Product product: products)
        {
            //第三步，根据每个产品的id去productImages表中查询产品的图片。
            List<ProductImage> productImages=  productService.findProductSmallImage(product.getId());
            if(productImages.size()>0)
            {
                product.setSmallimage("images/item/productDetailsPicture/"+productImages.get(0).getSrc());
            }
        }
        return  new Msg().success("products",products);
    }

    @GetMapping("/findProductsByCategory")
    public Msg findProductsByCategory()
    {

        List<Map<String,Object>> list = new ArrayList<>();

        List<FirstLevelCategory> categories = productService.getFirstCategory();
        for(FirstLevelCategory category : categories) {
            Map<String,Object> map = new HashMap<>();
            map.put("category",category);
            //第一步查出产品的信息
            List<Product> products=productService.findProductsByCategory(category.getId());

            for(Product product: products)
            {
                //第三步，根据每个产品的id去productImages表中查询产品的图片。
                List<ProductImage> productImages=  productService.findProductSmallImage(product.getId());
                if(productImages.size()>0)
                {
//                    product.setSmallimage("images/item/productDetailsPicture/"+productImages.get(0).getSrc());
                        //测试用
                    product.setSmallimage(productImages.get(0).getSrc());
                }
            }

            map.put("products",products);
            list.add(map);
        }


        //第二步，遍历产品信息集合

        return  new Msg().success("floors",list);
    }

    @RequestMapping("/findAllByCategory/first/{id}")
    public Msg findAllByFirstCategory(@RequestParam(value= "pn",defaultValue = "1") Integer pn,
                          @PathVariable(value = "id") Integer id,
                          @RequestParam(value = "ps",defaultValue = "20")Integer ps){
        int pageSize = ps;
        //在查询之前调用startPage方法，传入pn,pageSize
        PageHelper.startPage(pn,pageSize);
        //在startPage方法后紧跟一个查询，此查询是一个分页查询
        List<Product> products = productService.findAllByFirstLevelCategory(id);
        if(products==null){
            products=new ArrayList<Product>();
        }
        for(Product product:products) {
            List<ProductImage> productImages = productService.findProductSmallImage(product.getId());
            if(productImages.size()>0){
                product.setSmallimage(productImages.get(0).getSrc());
            }
            product.setBuyCount(productService.getBuyCount(product.getId()));
            product.setReviewCount(productService.getReviewCount(product.getId()));
        }
        //使用PageInfo来包装查询结果，只需将PageInfo传到前台即可,传入查询的结果和连续显示的页数
        PageInfo page = new PageInfo(products,pageSize);

        return Msg.success().success("pageInfo", page);
    }

    @RequestMapping("/findAllByCategory/third/{id}")
    public Msg findAllByThirdLevelCategory(@RequestParam(value= "pn",defaultValue = "1") Integer pn,
                          @PathVariable(value = "id") Integer id,
                          @RequestParam(value = "ps",defaultValue = "20")Integer ps){
        int pageSize = ps;
        //在查询之前调用startPage方法，传入pn,pageSize
        PageHelper.startPage(pn,pageSize);
        //在startPage方法后紧跟一个查询，此查询是一个分页查询
        List<Product> products = productService.findAllByThirdLevelCategory(id);
        if(products==null){
            products=new ArrayList<Product>();
        }
        for(Product product:products) {
            List<ProductImage> productImages = productService.findProductSmallImage(product.getId());
            if(productImages.size()>0){
                product.setSmallimage(productImages.get(0).getSrc());}
            product.setBuyCount(productService.getBuyCount(product.getId()));
            product.setReviewCount(productService.getReviewCount(product.getId()));
        }
        //使用PageInfo来包装查询结果，只需将PageInfo传到前台即可,传入查询的结果和连续显示的页数
        PageInfo page = new PageInfo(products,pageSize);

        return Msg.success().success("pageInfo", page);
    }

    @RequestMapping("/images/{id}")
    public Msg getImages(@PathVariable(value = "id") Integer id) {
        List<ProductImage> productImages = productService.findProductSmallImage(id);
//        for(ProductImage productImage:productImages) {
//            productImage.setSrc("images/item/productDetailsPicture"+productImage.getSrc());
//        }

        return new Msg().success("images",productImages);
    }

    @RequestMapping("/getProductById/{id}")
    public Msg getProductById(@PathVariable(value = "id") Integer id) {
        Msg msg = new Msg();
        Product product = productService.getProductById(id);
        if(product==null) {
            return Msg.fail();
        } else{
            msg.success("product",product);
            msg.success("images",productService.findProductSmallImage(product.getId()));
            msg.success("reviewCount",productService.getReviewCount(product.getId()));
            msg.success("buyCount",productService.getBuyCount(id));
        }
        return msg;
    }

    @RequestMapping("/detail/{id}")
    public Msg productDetails(@PathVariable(value = "id")Integer id) {
        Msg msg = new Msg();
        Product product = productService.getProductById(id);
        if(product==null) {
            return Msg.fail();
        } else{
            msg.success("product",product);
            msg.success("images",productService.findProductSmallImage(product.getId()));
            msg.success("reviewCount",productService.getReviewCount(product.getId()));
            msg.success("buyCount",productService.getBuyCount(id));
            List<Map<String,Object>> list = new ArrayList<>();
            List<PropertyValue> propertyValues = productService.getPropertyValue(id);
            if(propertyValues==null) {
                propertyValues = new ArrayList<>();
            }
            for(PropertyValue propertyValue:propertyValues) {
                Map<String,Object> map = new HashMap<>();
                map.put("value",propertyValue.getValue());
                map.put("key",productService.getProperty(propertyValue.getPropertyId()).getName());
                list.add(map);
            }
            msg.success("properties",list);
        }
        return msg;
    }

    @RequestMapping("/getReviews/{id}")
    public Msg getReviews(@PathVariable(value = "id")Integer id) {
        List<Review> reviews = productService.getReviewsByProduct(id);
        return new Msg().success("reviews",reviews);
    }

    @RequestMapping("/search")
    public Msg findByParam(@RequestParam(value= "pn",defaultValue = "1") Integer pn,
                                      @RequestParam(value = "param",required = true) String param,
                                      @RequestParam(value = "ps",defaultValue = "20")Integer ps){
        int pageSize = ps;
        //在查询之前调用startPage方法，传入pn,pageSize
        PageHelper.startPage(pn,pageSize);
        //在startPage方法后紧跟一个查询，此查询是一个分页查询
        List<Product> products = productService.getProductByParam(param);
        if(products==null){
            products=new ArrayList<Product>();
        }
        for(Product product:products) {
            List<ProductImage> productImages = productService.findProductSmallImage(product.getId());
            if(productImages.size()>0){
                product.setSmallimage(productImages.get(0).getSrc());
            }
            product.setBuyCount(productService.getBuyCount(product.getId()));
            product.setReviewCount(productService.getReviewCount(product.getId()));
        }
        //使用PageInfo来包装查询结果，只需将PageInfo传到前台即可,传入查询的结果和连续显示的页数
        PageInfo page = new PageInfo(products,pageSize);

        return Msg.success().success("pageInfo", page);
    }
}