function [ bestPatterns, minGlobal ] = bestsPatterns( patterns, qty )
%BESTSPATTERNS Summary of this function goes here
%   Detailed explanation goes here
    %for i=1:length(patterns(:, 1))
    %    fprintf('suma:%d - i: %d\n',sum(patterns(i,:)), i);
    %end
    n = length(patterns(:, 1));
    minGlobal = 100;
    for i=1:nchoosek(n, qty)/length(patterns(:,1))
        testIndexes = randperm(n);
        testIndexes = testIndexes(1:qty);
        testPatterns = patterns(testIndexes, :);
        maxct = 0;
        for j=1:qty
            hv = crossTalk(testPatterns, testPatterns(j, :));
            maxhv = max(hv);
            maxct = max(maxhv, maxct);
        end
        minGlobal
        maxct
        if (max(minGlobal, maxct) == minGlobal)
            bestPatterns = testPatterns;
            minGlobal = maxct;
        end
        if (minGlobal < 0.875)
            break;
        end
    end
end

