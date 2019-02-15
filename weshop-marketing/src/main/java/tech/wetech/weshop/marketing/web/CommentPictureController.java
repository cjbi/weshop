package tech.wetech.weshop.marketing.web;

import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.api.BaseApi;
import tech.wetech.weshop.marketing.api.CommentPictureApi;
import tech.wetech.weshop.marketing.po.CommentPicture;

@RestController
public class CommentPictureController extends BaseApi<CommentPicture> implements CommentPictureApi {


}
