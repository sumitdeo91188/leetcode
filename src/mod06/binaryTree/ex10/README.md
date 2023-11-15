# Construct Binary Tree from Inorder and Preorder Traversal

## Problem Statement

Given two integer arrays inorder and preorder where inorder is the inorder traversal of a binary tree and preorder is the preorder traversal of the same tree, construct and return the binary tree.



Example 1:


Input: inorder = [9,3,15,20,7], preorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: inorder = [-1], preorder = [-1]
Output: [-1]


Constraints:

1 <= inorder.length <= 3000
preorder.length == inorder.length
-3000 <= inorder[i], preorder[i] <= 3000
inorder and preorder consist of unique values.
Each value of preorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
preorder is guaranteed to be the preorder traversal of the tree.

## LeetCode link
https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/942/
