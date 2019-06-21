package tech.wetech.weshop.marketing.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.api.BaseApi;
import tech.wetech.weshop.marketing.api.CommentPictureApi;
import tech.wetech.weshop.marketing.po.CommentPicture;

@RestController
@RequestMapping("/commentPicture")
public class CommentPictureController extends BaseApi<CommentPicture> implements CommentPictureApi {


}
