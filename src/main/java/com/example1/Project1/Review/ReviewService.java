package com.example1.Project1.Review;

import java.util.List;

public interface ReviewService {
	List <Review>getAllReviews(Long companyId);
    boolean addReview(Long companyId,Review review);
    Review getReview(Long companyId,Long ReviewId);
	boolean updateReview(Long companyId, Long ReviewId,Review review);
	boolean deleteReview(Long companyId, Long reviewId);

}
