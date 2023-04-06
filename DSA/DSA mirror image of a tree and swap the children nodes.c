void preorder(node *temp) {
   if (temp != NULL) {
      if(temp->left!=NULL&&temp->right!=NULL){
          t = temp->left->data;
          temp->left->data= temp->right->data;
          temp->right->data=t;
       }
      preorder(temp->lchild);
      preorder(temp->rchild);
   }
}